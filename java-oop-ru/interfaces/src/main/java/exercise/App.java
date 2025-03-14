package exercise;

import java.util.List;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> apartments, int quantity) {
        return apartments.stream()
            .sorted(Home::compareTo)
            .limit(quantity)
            .map(Home::toString)
            .toList();
    }
}
// END
