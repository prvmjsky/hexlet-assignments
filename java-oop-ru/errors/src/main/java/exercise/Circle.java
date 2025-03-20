package exercise;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// BEGIN
@AllArgsConstructor
@Getter
@Setter
public class Circle {
    private Point point;
    private int radius;

    public double getSquare() throws NegativeRadiusException {
        if (radius < 0) {
            throw new NegativeRadiusException("Не удалось посчитать площадь");
        }

        return Math.PI * (radius * radius);
    }
}
// END
