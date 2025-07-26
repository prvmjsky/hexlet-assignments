package exercise;

import exercise.model.Address;
import exercise.annotation.Inspect;
import java.lang.reflect.Method;

public class Application {
    public static void main(String[] args) {
        var address = new Address("London", 12345678);

        // BEGIN
        var methods = address.getClass().getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Inspect.class)) {
                Inspect inspection = method.getAnnotation(Inspect.class);
                String name = method.getName();
                String type = method.getReturnType().getSimpleName();
                System.out.printf("Method %s returns a value of type %s%n", name, type);
            }
        }
        // END
    }
}
