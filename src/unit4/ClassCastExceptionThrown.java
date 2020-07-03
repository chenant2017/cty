package unit4;

public class ClassCastExceptionThrown {
	public static void main(String[] args) {
		Object i = 5;
		try {
			System.out.println((String)i); /**The program will compile successfully because i is declared as an instance of Object, which can be explicitly down-casted to a String. 
			However, since its actual type is Integer and an Integer object cannot be cast to a String, a ClassCastException will be thrown.*/
		}
		catch(ClassCastException ex) {
			System.out.println("Caught ClassCastException."); //To handle the exception, my program just displays that it caught the exception.
		}
		finally {
			System.out.println("Program ended."); //Tells the user that the program has ended.
		}
	}
}
