package utilities;
import java.util.Comparator;
import shapes.Shape;
/**
* Implements the Selection Sort algorithm in descending order.
*/
public class SelectionSort {
    /**
     * Sorts the array of Shapes using Selection Sort.
     * @param array The array to be sorted.
     * @param comparator The comparator defining the sort order.
     */
    public static void selectionSort(Shape[] array, Comparator<Shape> comparator) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            // Find the index of the largest element in the unsorted portion array[i..n-1]
            int max_idx = i;
            for (int j = i + 1; j < n; j++) {
                // (comparator.compare(array[j], array[max_idx]) > 0) means array[j] > array[max_idx] (ascending logic).
                // To find the largest element for descending sort, we need array[j] > array[max_idx].
                if (comparator.compare(array[j], array[max_idx]) > 0) {
                    max_idx = j;
                }
            }
            // Swap the found largest element with the first element (array[i])
            Shape temp = array[max_idx];
            array[max_idx] = array[i];
            array[i] = temp;
        }
    }
}
