package exercise;

import java.util.List;
import java.util.Map;

// BEGIN
public final class PairedTag extends Tag {
    private String body;
    private List<Tag> children;

    public PairedTag(String tagName, Map<String, String> attributes, String body, List<Tag> children) {
        super(tagName, attributes);
        this.body = body;
        this.children = children;
    }

    public PairedTag(String tagName, Map<String, String> attributes) {
        super(tagName, attributes);
    }

    @Override
    public String toString() {
        if (body == null) {
            return String.format("<%s" + " %s>" + "</%s>",
                tagName, attributesToString(), tagName);
        }

        StringBuilder childrenString = new StringBuilder();
        children.forEach(child -> {
            childrenString.append(child.toString());
        });

        return String.format("<%s" + " %s>" + "%s" + "%s" + "</%s>",
            tagName, attributesToString(), childrenString, body, tagName);
    }
}
// END
