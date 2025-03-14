package exercise;

// BEGIN
public class Cottage implements Home {
    private double area;
    private int floor;

    public Cottage(double area, int floor) {
        this.area = area;
        this.floor = floor;
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public int compareTo(Home another) {
        return Double.compare(this.getArea(), another.getArea());
    }

    @Override
    public String toString() {
        return floor + " этажный коттедж площадью " + this.getArea() + " метров";
    }
}
// END
