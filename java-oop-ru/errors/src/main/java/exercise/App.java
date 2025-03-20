package exercise;

// BEGIN
public class App {
    public static void printSquare(Circle circle) {
        try {
            var roundedSquare = Math.round(circle.getSquare());
            System.out.print(roundedSquare + "\n");
        } catch (NegativeRadiusException e) {
            System.out.print(e.getMessage() + "\n");
        } finally {
            System.out.print("Вычисление окончено" + "\n");
        }
    }
}
// END
