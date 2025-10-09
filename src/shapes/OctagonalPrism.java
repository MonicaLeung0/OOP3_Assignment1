package shapes;

public class OctagonalPrism extends Prism {
    public OctagonalPrism(double height, double edge) {
        super(height, edge);
    }

    @Override
    public double calcBaseArea() {
        // Formula: 2(1 + √2)s²
        return 2 * (1 + Math.sqrt(2)) * edge * edge;
    }
}
