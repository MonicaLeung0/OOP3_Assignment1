package utilities;
import java.util.Comparator;
import shapes.Shape;
/**
* Implements the Insertion Sort algorithm in descending order.
*/
public class InsertionSort {
    /**
     * Sorts the array of Shapes using Insertion Sort.
     * @param array The array to be sorted.
     * @param comparator The comparator defining the sort order.
     */
    public static void insertionSort(Shape[] array, Comparator<Shape> comparator) {
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            Shape key = array[i]; // The element to be inserted
            int j = i - 1;
            // Move elements of array[0..i-1], that are smaller than key,
            // to one position ahead of their current position.
            // (comparator.compare(array[j], key) < 0) means array[j] < key (ascending logic).
            // Since we need descending, this condition ensures the smaller element (array[j])
            // is shifted right to make room for the larger element (key).
            while (j >= 0 && comparator.compare(array[j], key) < 0) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }
}