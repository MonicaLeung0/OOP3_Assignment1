package shapes;

public abstract class Prism extends Shape {
    protected double height;
    protected double edge;

    public Prism(double height, double edge) {
        this.height = height;
        this.edge = edge;
    }
    
    @Override
    public double getHeight() {
    	
    	return height;
    	
    }

    @Override
    public double calcVolume() {
        return calcBaseArea() * height;
    }
}
