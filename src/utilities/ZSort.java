package utilities;
import java.util.Comparator;
import shapes.Shape;
/**
* Implements Shell Sort (Z sort choice) in descending order.
*/
public class ZSort {
    /**
     * Sorts the array of Shapes using Shell Sort.
     * @param array The array to be sorted.
     * @param comparator The comparator defining the sort order.
     */
    public static void zSort(Shape[] array, Comparator<Shape> comparator) {
        int n = array.length;
        // Start with a large gap, then reduce the gap (Knuth's sequence: 3h + 1)
        int gap = 1;
        while (gap < n / 3) {
            gap = 3 * gap + 1;
        }
        while (gap >= 1) {
            // Perform gap-sorted insertion sort
            for (int i = gap; i < n; i++) {
                Shape temp = array[i];
                int j = i;
                // Insertion logic for descending order:
                // Shift element A[j-gap] to the right if it is SMALLER than the element being inserted (temp).
                // comparator.compare(array[j - gap], temp) < 0 means array[j-gap] < temp.
                while (j >= gap && comparator.compare(array[j - gap], temp) < 0) {
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = temp;
            }
            // Move to the next smallest gap
            gap /= 3;
        }
    }
}
