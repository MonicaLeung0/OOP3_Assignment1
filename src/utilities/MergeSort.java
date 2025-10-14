package utilities;
import java.util.Comparator;
import shapes.Shape;
/**
* Implements the Merge Sort algorithm in descending order.
*/
public class MergeSort {
    /**
     * Public method to start the Merge Sort process.
     * @param array The array to be sorted.
     * @param comparator The comparator defining the sort order.
     */
    public static void mergeSort(Shape[] array, Comparator<Shape> comparator) {
        if (array == null || array.length < 2) {
            return;
        }
mergeSortRecursive(array, new Shape[array.length], 0, array.length - 1, comparator);
    }
    private static void mergeSortRecursive(Shape[] array, Shape[] aux, int low, int high, Comparator<Shape> comparator) {
        if (low >= high) { // Base case: one element
            return;
        }
        int mid = low + (high - low) / 2; // Avoids overflow compared to (low + high) / 2
mergeSortRecursive(array, aux, low, mid, comparator);      // Sort left half
mergeSortRecursive(array, aux, mid + 1, high, comparator); // Sort right half
merge(array, aux, low, mid, high, comparator);             // Merge results
    }
    private static void merge(Shape[] array, Shape[] aux, int low, int mid, int high, Comparator<Shape> comparator) {
        // Copy data to auxiliary array
        for (int k = low; k <= high; k++) {
            aux[k] = array[k];
        }
        int i = low;      // pointer for left sub-array
        int j = mid + 1;  // pointer for right sub-array
        for (int k = low; k <= high; k++) {
            if (i > mid) {             // Left sub-array exhausted, take from right
                array[k] = aux[j++];
            } else if (j > high) {     // Right sub-array exhausted, take from left
                array[k] = aux[i++];
            }
            // Compare aux[i] and aux[j]. If aux[i] is smaller than aux[j] (comparison < 0),
            // for descending sort, we take the LARGER element, which is aux[j].
            // If comparator.compare(aux[i], aux[j]) < 0, it means aux[i] is smaller than aux[j].
            // We want the larger one (aux[j]) to go first (to the left in array[k]).
            else if (comparator.compare(aux[i], aux[j]) < 0) {
                array[k] = aux[j++]; // Take from the right (larger)
            } else {
                array[k] = aux[i++]; // Take from the left (larger or equal)
            }
        }
    }
}