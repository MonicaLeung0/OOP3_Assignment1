package shapes;

public class PentagonalPrism extends Prism {
    public PentagonalPrism(double height, double edge) {
        super(height, edge);
    }

    @Override
    public double calcBaseArea() {
        // Formula: (5 * s^2 * tan(54°)) / 4
        return (5.0 / 4.0) * edge * edge * Math.tan(Math.toRadians(54));
    }

}
