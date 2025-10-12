package shapes;

public class Cylinder extends Shape {
    private double height;
    private double radius;

    public Cylinder(double height, double radius) {
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
        return calcBaseArea() * height;
    }

}
