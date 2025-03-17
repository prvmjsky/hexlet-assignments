package exercise;

import lombok.AllArgsConstructor;

// BEGIN
@AllArgsConstructor
public class LabelTag implements TagInterface {
    private String value;
    private TagInterface tag;

    @Override
    public String render() {
        return "<label>%s%s</label>".formatted(value, tag.render());
    }
}
// END
