package appDomain;

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
        String fullPath = "res\\" + fileName;
        
        

		// refer to demo01 Test.java for an example on how to parse command
		// line arguments and benchmarking tests

		// refer to demo02 Student.java for comparable implementation, and
		// NameCompare.java or GradeCompare for comparator implementations

		// refer to demo02 KittySort.java on how to use a custom sorting
		// algorithm on a list of comparables to sort using either the
		// natural order (comparable) or other orders (comparators)

	}

}
