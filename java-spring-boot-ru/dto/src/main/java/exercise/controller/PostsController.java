package exercise.controller;

import exercise.exception.ResourceNotFoundException;
import exercise.model.Comment;
import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.dto.PostDTO;
import exercise.dto.CommentDTO;

// BEGIN
@RestController
@RequestMapping("/posts")
public class PostsController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping
    public List<PostDTO> index() {
        var posts = postRepository.findAll();
        return posts.stream()
            .map(this::postToDTO)
            .toList();
    }

    @GetMapping("/{id}")
    public PostDTO show(@PathVariable Long id) throws ResourceNotFoundException {
        var post = postRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException(String.format("Post with id %d not found", id)));
        return postToDTO(post);
    }

    private PostDTO postToDTO(Post post) {
        var dto = new PostDTO();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setBody(post.getBody());

        var comments = commentRepository.findByPostId(post.getId()).stream()
            .map(this::commentToDTO)
            .toList();
        dto.setComments(comments);

        return dto;
    }

    private CommentDTO commentToDTO(Comment comment) {
        var dto = new CommentDTO();
        dto.setId(comment.getId());
        dto.setBody(comment.getBody());
        return dto;
    }
}
// END
