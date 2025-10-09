package shapes;

public class Pyramid extends Shape {
    private double height;
    private double edge;

    public Pyramid(double height, double edge) {
        this.height = height;
        this.edge = edge;
    }

    @Override
    public double calcBaseArea() {
        return edge * edge;
    }

    @Override
    public double calcVolume() {
        return (1.0 / 3.0) * calcBaseArea() * height;
    }

}
