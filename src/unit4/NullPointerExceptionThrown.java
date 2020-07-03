package unit4;

public class NullPointerExceptionThrown {
	public static void main(String[] args) {
		String s = null;
		try {
			System.out.println(s.charAt(0)); //Since s has a value of null, Java is unable to successfully invoke the charAt method and throws a NullPointerException instead.
		}
		catch(NullPointerException ex) { //To handle the exception, my program just displays that it caught the exception.
			System.out.println("Caught NullPointerException.");
		}
		finally {
			System.out.println("Program ended."); //Tells the user that the program has ended.
		}
	}
}
