package shapes;

public abstract class Shape implements Comparable<Shape>{
	
    public abstract double calcBaseArea();
    public abstract double calcVolume();
    public abstract double getHeight();
    
    //for use if no custom comparator is provided
    @Override
    public int compareTo(Shape other) {
    	//if we call Arrays.sort(shapes) it will sort by height automatically....
    	//as always comparator is passes thus compare() is used ....
    	return Double.compare(this.getHeight(), other.getHeight());
    	
    }
    
}
