package appDomain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;

import shapes.*;
import utilities.*;

/**
 * <p>
 * This application driver code is designed to be used as a basis for the
 * Complexity and Sorting assignment that will be developed in the CPRG304 F2025
 * class at SAIT. The implementors of this applications will be required to add
 * all the correct functionality.
 * </p>
 */
public class AppDriver {
	/**
	 * The main method is the entry point of the application.
	 * 
	 * @param args The input to control the execution of the application.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String fileName = null;
		String sortType = null;
		String sortAlgorithm = null;

		// read args 
		/*
		 * startsWith() checks a prefix
		 * substring(2) removes -f, -t, or -s part and thus keeps the actual value for fileName, sortType, and sortAlgorithm....
		 * */
		for (String arg : args) {

			if (arg.startsWith("-f") || arg.startsWith("-F")) {
				fileName = arg.substring(2); // get text after "-f" prefix
			} else if (arg.startsWith("-t") || arg.startsWith("-T")) {
				sortType = arg.substring(2); // get v, h, or a
			} else if (arg.startsWith("-s") || arg.startsWith("-S")) {
				sortAlgorithm = arg.substring(2); // get b, s, i, m, q, z
			}
		}

		// Validation for all required arguments if they are provided or not....

		if (fileName == null || sortType == null || sortAlgorithm == null) {

			System.out.println("Error: Missing required arguments!");
			printUsage();
			return;

		}

		// refer to demo00 BasicFileIO.java for a simple example on how to
		// read data from a text file
		
		String filePath;
		//user passes a path or filename...
		if(fileName.contains("\\") || fileName.contains("/") || fileName.matches("^[A-Za-z]:.*")) {
			filePath = fileName;
		}else {
			filePath = "res\\" + fileName; //this is the default to res(resources ) folder....
		}

		/*
		 * file handling and reading shapes....
		 * */
		Shape[] shapes = null;

		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			// Read first line that is number of shapes
			int count = Integer.parseInt(reader.readLine().trim());
			System.out.println("Number of shapes: " + count);

			// Create array for shapes (a fixed-size array)....
			shapes = new Shape[count];

			// Read shape data lines and object creation....
			for (int i = 0; i < count; i++) {
				String line = reader.readLine();
				if (line == null)
					break; // end of file early
				
				//.split("\\s+") splits the line by spaces or tabs....
				String[] parts = line.trim().split("\\s+");
				//each shape has 3 parts: name, height and radius/edge length
				if (parts.length != 3) {
					System.out.println("Invalid line format: " + line);
					continue;
				}

				String shapeName = parts[0];
				//height
				double h = Double.parseDouble(parts[1]);
				// radius or edge length....
				double re = Double.parseDouble(parts[2]);

				Shape shape = null;

				// Create correct shape object
				switch (shapeName.toLowerCase()) {
				case "cylinder":
					shape = new Cylinder(h, re);
					break;
				case "cone":
					shape = new Cone(h, re);
					break;
				case "pyramid":
					shape = new Pyramid(h, re);
					break;
				case "squareprism":
					shape = new SquarePrism(h, re);
					break;
				case "triangularprism":
					shape = new TriangularPrism(h, re);
					break;
				case "pentagonalprism":
					shape = new PentagonalPrism(h, re);
					break;
				case "octagonalprism":
					shape = new OctagonalPrism(h, re);
					break;
				default:
					System.out.println("Unknown shape type: " + shapeName);
					continue;
				}
				// Add shape to array
				shapes[i] = shape;
			}
		} catch (IOException e) {

			System.out.println("Error reading file: " + e.getMessage());
			return;

		}

		if (shapes == null || shapes.length == 0) {

			System.out.println("No shapes were read successfully from file! ");
			return;

		}

		// refer to demo01 Test.java for an example on how to parse command
		// line arguments and benchmarking tests

		// refer to demo02 Student.java for comparable implementation, and
		// NameCompare.java or GradeCompare for comparator implementations

		// refer to demo02 KittySort.java on how to use a custom sorting
		// algorithm on a list of comparables to sort using either the
		// natural order (comparable) or other orders (comparators)

		// calls helper class ShapeComparator to get the correct comparison rule....
		//each comparator will return a custom rule for comparing two shapes....
		/*
		 * if user chooses 
		 *  -th then compare heights
		 *  -ta then compare base area 
		 *  -tv then compare volume
		 * */
		Comparator<Shape> comparator = ShapeComparator.getComparator(sortType);

		// Benchmarking the sorting....
		//System.nanotime() measures the time precisely....
		//sort algorithms uses comparator to decide order....
		//it sorts the Shape[] array....
		long starttime = System.nanoTime();

		switch (sortAlgorithm.toLowerCase()) {

			case "b":
				BubbleSort.bubbleSort(shapes, comparator);
				break;
			case "s":
				// SelectionSort.selectionSort(shapes, comparator);
				break;
			case "i":
				// InsertionSort.insertionSort(shapes, comparator);
				break;
			case "m":
				// MergeSort.mergeSort(shapes, comparator);
				break;
			case "q":
				QuickSort.quickSort(shapes, comparator);
				break;
			case "z":
				// z.zSort(shapes, comparator);
				break;

		}
		//long is safer to use as int can cause to overflow for large values....
		long endtime = System.nanoTime();
		//1 second = 1,000,000,000 nanoseconds
		//calculating how the time sorting process took in milliseconds....
		long duration = (endtime - starttime) / 1000000;

		System.out.println("\nSorting completed successfully!");

		printSortedResults(shapes, sortType, sortAlgorithm, duration);
		

	}
	
	/*
	 * used for printing first element (largest,since descending order), 
	 * every 1000th element and last element. Also prints the runtime.
	 * */

	private static void printSortedResults(Shape[] shapes, String sortType, String sortAlgorithm, long duration) {

		String algorithmName = getAlgorithmName(sortAlgorithm);

		String sortTypeName = getSortTypeName(sortType);

		// Print first Element
		//printf() used for formatted output....
		//%n used for new line like \n, %.4f is used to limit decimal places to 4....
		//%-18 is left aligned and %18 is right aligned in 18-character wide field....
		System.out.printf("%-18s%-20s%-10s : %.4f%n","First element is: shapes.",shapes[0].getClass().getSimpleName(), sortTypeName, getSortValue(shapes[0],sortType));

		// Print every 1000th element
		for (int i = 999; i < shapes.length; i += 1000) {

			System.out.printf("%-18s%-20s %-10s : %.4f%n",(i + 1) + "-th element: shapes." ,shapes[i].getClass().getSimpleName(), sortTypeName ,getSortValue(shapes[i], sortType));

		}

		// Print Last element
		System.out.printf("%-18s%-20s%-10s : %.4f%n","Last element is: shapes.",shapes[shapes.length - 1].getClass().getSimpleName(), sortTypeName, getSortValue(shapes[shapes.length - 1], sortType));

		// Print timing
		System.out.println(algorithmName + " run time was: " + duration + " milliseconds");

	}

	/*
	 * helper methods : getSortValue(), getSortTypeName() , getAlgorithmName() ..... used to make more code readable....
	 * */
	private static double getSortValue(Shape shape, String sortType) {
    	
    	switch (sortType.toLowerCase()) {
		case "h": return shape.getHeight();
		case "a": return shape.calcBaseArea();
		case "v": return shape.calcVolume();  	
		default: return 0;
    	}
    }

	private static String getSortTypeName(String sortType) {
    		
    	switch (sortType.toLowerCase()) {
    			
			case "h" : return "Height";
			case "a" : return "Area";
			case "v" : return "Volume";
			default : return "Value";
			
			
		}
    	
    }

	private static String getAlgorithmName(String sortAlgorithm) {

		switch (sortAlgorithm.toLowerCase()) {
		case "b":
			return "Bubble Sort";
		case "s":
			return "Selection Sort";
		case "i":
			return "Insertion Sort";
		case "m":
			return "Merge Sort";
		case "q":
			return "Quick Sort";
		case "z":
			return "z Sort";
		default:
			return "Unknown Algorithm";
		}

	}

	private static void printUsage() {

		System.out.println(" -f File name (e.g., shapes1.txt)");
		System.out.println(" -t Sort type h (height), a (base area), v (volume)");
		System.out.println(" -s Sort algorithm: b (bubble), s(selection), i (insertion), m (merge), q (quick), z (z)");
		System.out.println("\n Example");
		System.out.println(" java -jar Sort.jar -fshapes1.txt -Tv -Sb)");
		System.out.println(" java -jar Sort.jar -ta -sQ -f\"res\\shapes1.txt\"");
		System.out.println(" java -jar Sort.jar -tH -F\"C:\\temp\\shapes.txt\" -sB");

	}
	
	//checker method to verify if array is sorted in descending order or not using given comparator....
	//comparator<Shape> how shapes are compared height, area , or volume...
	private static boolean isSorted(Shape[] shapes, Comparator<Shape> comparator) {
		//loops through every pair of consecutive elements comparing element i with element (i + 1) and stops before last index so doesn't go out of bounds....
	    for (int i = 0; i < shapes.length - 1; i++) {
	    	//if element i is smaller that (i+1) that means array is not sorted as smaller value is before larger what should be descending order...  
	        if (comparator.compare(shapes[i], shapes[i + 1]) < 0) {
	            System.out.println("NOT SORTED at position " + i);
	            return false;
	        }
	    }
	    return true;
	}

}
