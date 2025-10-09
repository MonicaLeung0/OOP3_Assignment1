package shapes;

public class SquarePrism extends Prism {
    public SquarePrism(double height, double edge) {
        super(height, edge);
    }

    @Override
    public double calcBaseArea() {
        return edge * edge;
    }
}
