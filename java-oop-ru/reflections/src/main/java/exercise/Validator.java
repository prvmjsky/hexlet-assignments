package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {
    public static List<String> validate(Object object) {

        var fields = object.getClass().getDeclaredFields();

        return Arrays.stream(fields)
            .filter(field -> field.isAnnotationPresent(NotNull.class))
            .filter(field -> {
                try {
                    field.setAccessible(true);
                    return field.get(object) == null;
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            })
            .map(Field::getName)
            .toList();
    }

    public static Map<String, List<String>> advancedValidate(Object object) {

        var fields = object.getClass().getDeclaredFields();
        var wrongFields = new HashMap<String, List<String>>();

        for (var field : fields) {
            var errors = new ArrayList<String>();
            String value;

            try {
                field.setAccessible(true);
                value = (String) field.get(object);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }

            if (field.isAnnotationPresent(NotNull.class) && value == null) {
                errors.add("can not be null");
            }

            if (field.isAnnotationPresent(MinLength.class)) {
                int minLength = field.getAnnotation(MinLength.class).minLength();

                if (value == null || value.length() < minLength) {
                    errors.add("length less than " + minLength);
                }
            }

            if (!errors.isEmpty()) {
                wrongFields.put(field.getName(), errors);
            }
        }

        return wrongFields;
    }
}
// END
