package appDomain;

import java.util.Comparator;
import shapes.Shape;

public class ShapeComparator {
	
	public static Comparator<Shape> getComparator(String type) {
		
		switch (type.toLowerCase()) {
		case "h":
			return new HeightComparator();
			
		case "a":
			return new BaseAreaComparator();
			
		case "v":
			return new VolumeComparator();
			
		default:
			throw new IllegalArgumentException("Comparasion Type is invalid: " + type);
			
		}
		
	}
	
	private static class HeightComparator implements Comparator<Shape> {
		
		@Override
		public int compare(Shape shape1, Shape shape2) {
			
			return Double.compare(shape2.getHeight(), shape1.getHeight());
			
		}
		
	}
	
	private static class BaseAreaComparator implements Comparator<Shape> {
		
		@Override
		public int compare(Shape shape1, Shape shape2) {
			
			return Double.compare(shape2.calcBaseArea(), shape1.calcBaseArea());
			
		}
		
	}
	
	private static class VolumeComparator implements Comparator<Shape> {
		
		@Override
		public int compare(Shape shape1, Shape shape2) {
			
			return Double.compare(shape2.calcVolume(), shape1.calcVolume());
			
		}
		
	}

}
