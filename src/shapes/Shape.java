package shapes;

public abstract class Shape implements Comparable<Shape>{	
    public abstract double calcBaseArea();
    public abstract double calcVolume();
    public abstract double getHeight();
    
    @Override
    public int compareTo(Shape other) {
    	
    	return Double.compare(this.getHeight(), other.getHeight());
    	
    }
    
}
