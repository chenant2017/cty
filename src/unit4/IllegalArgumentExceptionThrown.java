package unit4;

public class IllegalArgumentExceptionThrown {
	public static void main(String[] args) {
		try {
			displayPositiveInteger(-5); //displayPositiveInteger will throw an IllegalArgumentException
		}
		catch (IllegalArgumentException ex) {
			System.out.println("Caught IllegalArgumentException."); //To handle the exception, my program just displays that it caught the exception.
		}
		finally {
			System.out.println("Program ended."); //Tells the user that the program has ended.
		}
	}
	public static void displayPositiveInteger(int i) { // The throws clause is not needed because the IllegalArgumentException is unchecked.
		if (i > 0) {
			System.out.println(i + " is an example of a positive integer.");
		}
		else {
			throw new IllegalArgumentException();
		}
	}
}
