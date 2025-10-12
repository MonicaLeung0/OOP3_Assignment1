package appDomain;

import java.util.Comparator;
import shapes.Shape;

public class SortingAlgorithms {
	
	//bubble sort 
	//selection sort
	//insertion Sort
	//Merge Sort
	
	//Quick Sort 
	public static void quickSort(Shape[] array, Comparator<Shape> comparator) {
		
		quickSort(array, 0, array.length - 1, comparator);
		
	}
	
	private static void quickSort(Shape[] array, int low, int high, Comparator<Shape> comparator) {
		
		if(low < high) {
			
			int p = partition(array, low, high, comparator);
			quickSort(array, low, p - 1, comparator);
			quickSort(array, p + 1, high, comparator);
			
		}
		
	}
	
	private static int partition(Shape[] array, int low, int high, Comparator<Shape> comparator) {
		
		Shape pivot = array[high];
		int i = low - 1;
		
		for (int j = low; j < high; j++) {
			
			if(comparator.compare(array[j], pivot) <= 0) {
				
				i++;
				Shape temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				
			}
			
		}
		
		Shape temp = array[i + 1];
		array[i + 1] = array[high];
		array[high] = temp;
		return i + 1;
		
	}
	
	//your choice of sort 

}
