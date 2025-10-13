package appDomain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;

import shapes.*;


/**
 * <p>
 * This application driver code is designed to be used as a basis for the
 * Complexity and Sorting assignment that will be developed in the CPRG304 
 * F2025 class at SAIT. The implementors of this applications will be required
 * to add all the correct functionality.
 * </p>
 */
public class AppDriver
{
	/**
	 *  The main method is the entry point of the application.
	 *  
	 *  @param args The input to control the execution of the application.
	 */
	public static void main( String[] args )
	{
		// TODO Auto-generated method stub
		
		String fileName = null;
        String sortType = null;
        String sortAlgorithm = null;
        
        //read args
        for (String arg : args) {
        	
            if (arg.startsWith("-f") || arg.startsWith("-F")) {
                fileName = arg.substring(2); // get text after "-f"
            } else if (arg.startsWith("-t") || arg.startsWith("-T")) {
                sortType = arg.substring(2); // get v, h, or a
            } else if (arg.startsWith("-s") || arg.startsWith("-S")) {
                sortAlgorithm = arg.substring(2); // get b, s, i, m, q, z
            }
        }     

		// refer to demo00 BasicFileIO.java for a simple example on how to
		// read data from a text file
        String filePath = "res\\" + fileName;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) 
        {
            // Read first line: number of shapes
            int count = Integer.parseInt(reader.readLine().trim());
            System.out.println("Number of shapes: " + count);

            // Create array for shapes
            Shape[] shapes = new Shape[count];

            // Read shape data lines
            for (int i = 0; i < count; i++) 
            {
                String line = reader.readLine();
                if (line == null) break; // end of file early

                String[] parts = line.trim().split("\\s+");
                if (parts.length != 3) {
                    System.out.println("Invalid line format: " + line);
                    continue;
                }

                String shapeName = parts[0];
                double h = Double.parseDouble(parts[1]);
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
        } 
        catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
            

		// refer to demo01 Test.java for an example on how to parse command
		// line arguments and benchmarking tests

		// refer to demo02 Student.java for comparable implementation, and
		// NameCompare.java or GradeCompare for comparator implementations

		// refer to demo02 KittySort.java on how to use a custom sorting
		// algorithm on a list of comparables to sort using either the
		// natural order (comparable) or other orders (comparators)

	}

}
