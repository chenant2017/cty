package unit4;

public class ArrayIndexOutOfBoundsExceptionThrown {
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5};
		try {
			for (int i = 0; i <= array.length; i++) { //When i becomes 5, Java will throw an ArrayIndexOutOfBoundsException because array[5] is out of bounds.
				System.out.println(array[i]);
			}
		}
		catch(ArrayIndexOutOfBoundsException ex) { //To handle the exception, my program just displays that it caught the exception.
			System.out.println("Caught ArrayIndexOutOfBoundsException.");
		}
		finally {
			System.out.println("Program ended."); //Tells the user that the program has ended.
		}
	}
}
