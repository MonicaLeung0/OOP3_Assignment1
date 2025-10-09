package shapes;

public class TriangularPrism extends Prism {
    public TriangularPrism(double height, double edge) {
        super(height, edge);
    }

    @Override
    public double calcBaseArea() {
        return (Math.sqrt(3) / 4) * edge * edge;
    }
}
