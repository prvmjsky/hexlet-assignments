package exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import exercise.model.Contact;
import exercise.repository.ContactRepository;
import exercise.dto.ContactDTO;
import exercise.dto.ContactCreateDTO;

@RestController
@RequestMapping("/contacts")
public class ContactsController {

    @Autowired
    private ContactRepository contactRepository;

    // BEGIN
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContactDTO create(@RequestBody ContactCreateDTO data) {
        var contact = toEntity(data);
        contactRepository.save(contact);
        return toDTO(contact);
    }

    private Contact toEntity(ContactCreateDTO data) {
        var entity = new Contact();
        entity.setFirstName(data.getFirstName());
        entity.setLastName(data.getLastName());
        entity.setPhone(data.getPhone());
        return entity;
    }

    private ContactDTO toDTO(Contact entity) {
        var data = new ContactDTO();
        data.setId(entity.getId());
        data.setFirstName(entity.getFirstName());
        data.setLastName(entity.getLastName());
        data.setPhone(entity.getPhone());
        data.setCreatedAt(entity.getCreatedAt());
        data.setUpdatedAt(entity.getUpdatedAt());
        return data;
    }
    // END
}
