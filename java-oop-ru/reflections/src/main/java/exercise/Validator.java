package exercise;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {
    public static List<String> validate(Object object) {
        var aClass = object.getClass();
        var fields = aClass.getDeclaredFields();

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
        var wrongFields = new LinkedHashMap<String, List<String>>();

		var aClass = object.getClass();
		var fields = aClass.getDeclaredFields();



        return wrongFields;
    }
}
// END
