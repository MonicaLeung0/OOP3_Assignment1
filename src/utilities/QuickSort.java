package utilities;

import java.util.Comparator;

import shapes.Shape;

/**
 * Sorts the array of Shapes using Quick Sort.
 * @param array The array to be sorted.
 * @param comparator The comparator defining the sort order.
 */

public class QuickSort {
	
	//Quick Sort 
		public static void quickSort(Shape[] array, Comparator<Shape> comparator) {
			
			quickSort(array, 0, array.length - 1, comparator);
			
		}
		
		private static void quickSort(Shape[] array, int low, int high, Comparator<Shape> comparator) {
			//it checks if there is more than one element....
			if(low < high) {
				
				int p = partition(array, low, high, comparator);
				quickSort(array, low, p - 1, comparator);
				quickSort(array, p + 1, high, comparator);
				
			}
			
		}
		
		private static int partition(Shape[] array, int low, int high, Comparator<Shape> comparator) {
			
			Shape pivot = array[high]; //picks last element as pivot.... (pivot is reference element we compare the others to....
			int i = low - 1; 
			
			for (int j = low; j < high; j++) {
				//sorts in descending order as checks >= 0 .... largest elements go to right....
				if(comparator.compare(array[j], pivot) >= 0) {
					
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

}
