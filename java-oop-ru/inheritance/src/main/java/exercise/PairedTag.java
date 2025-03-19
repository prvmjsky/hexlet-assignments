package exercise;

import lombok.Setter;

import java.util.List;
import java.util.Map;

// BEGIN
@Setter
public final class PairedTag extends Tag {
    private String body;
    private List<Tag> children;

    public PairedTag(String tagName, Map<String, String> attributes, String body, List<Tag> children) {
        super(tagName, attributes);
        this.body = body;
        this.children = children;
    }

    @Override
    public String toString() {

        StringBuilder childrenString = new StringBuilder();
        children.forEach(child -> {
            childrenString.append(child.toString());
        });

        var suffix = attributes.isEmpty() ? "" : " ";

        return String.format("<%s%s%s>" + "%s" + "%s" + "</%s>",
            tagName, suffix, attributesToString(), childrenString, body, tagName);
    }
}
// END
