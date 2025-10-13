package utilities;
import java.util.Comparator;
import shapes.Shape;





public class BubbleSort {
	
	// Bubble Sort (Descending Order)
	public static void bubbleSort(Shape[] array, Comparator<Shape> comparator) {
		
		int n = array.length;
		boolean swapped;
		
		for (int i = 0; i < n - 1; i++) {
			swapped = false;
			
			for (int j = 0; j < n - i - 1; j++) {
				//if the current element is smaller than the next element
            	// then swap them to move the smaller element to the right(descending)
				if (comparator.compare(array[j], array[j + 1]) < 0) {
					// swap arr[j] and arr[j+1]
					Shape temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					swapped = true;
				}
			}
			// If no swaps occurred, the array is already sorted
			if (!swapped) {
				break;
			}
		}
		
	}

}
