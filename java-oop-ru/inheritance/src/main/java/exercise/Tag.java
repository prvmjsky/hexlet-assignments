package exercise;

import lombok.Getter;
import lombok.AllArgsConstructor;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
@AllArgsConstructor
@Getter
public abstract class Tag {
    protected String tagName;
    protected Map<String, String> attributes;

    protected String attributesToString() {
        return attributes.entrySet().stream()
            .map((entry) -> String.format("%s=\"%s\"", entry.getKey(), entry.getValue()))
            .collect(Collectors.joining(" "));
    }

    public abstract String toString();
}
// END
