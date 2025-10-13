package shapes;

public class Cone extends Shape {
    private double height;
    private double radius;

    public Cone(double height, double radius) {
        this.height = height;
        this.radius = radius;
    }
    
    @Override
    public double getHeight() {
    	
    	return height;
    	
    }

    @Override
    public double calcBaseArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calcVolume() {
        return (1.0 / 3.0) * calcBaseArea() * height;
    }

}
