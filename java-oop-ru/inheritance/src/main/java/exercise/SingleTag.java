package exercise;

import java.util.Map;

// BEGIN
public final class SingleTag extends Tag {
    public SingleTag(String tagName, Map<String, String> attributes) {
        super(tagName, attributes);
    }

    @Override
    public String toString() {

        var suffix = attributes.isEmpty() ? "" : " ";

        return String.format("<%s%s%s>",
            tagName, suffix, attributesToString());
    }
}
// END
