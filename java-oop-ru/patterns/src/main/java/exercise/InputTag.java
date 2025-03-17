package exercise;

import lombok.AllArgsConstructor;

// BEGIN
@AllArgsConstructor
public class InputTag implements TagInterface {
    private String type;
    private String value;

    @Override
    public String render() {
        return "<input type=\"%s\" value=\"%s\">".formatted(type, value);
    }
}
// END
