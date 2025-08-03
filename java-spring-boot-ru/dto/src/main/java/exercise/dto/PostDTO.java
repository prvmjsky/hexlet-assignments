package exercise.dto;

import java.util.ArrayList;
import java.util.List;

import exercise.model.Comment;
import lombok.Getter;
import lombok.Setter;

// BEGIN
@Getter
@Setter
public class PostDTO {
    private Long id;
    private String title;
    private String body;
    private List<CommentDTO> comments;

    public void addComment(CommentDTO comment) {

        if (comments == null) {
            comments = new ArrayList<>();
        }

        comments.add(comment);
    }
}
// END
