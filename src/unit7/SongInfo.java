package unit7;

import java.util.*;
import java.io.*;

public class SongInfo {
	public static void main(String[] args) throws IOException {
		try (
				Scanner input = new Scanner(System.in);
		) {
			System.out.print("Please enter the name of the file you would like the program to write to: ");
			File file = new File(input.nextLine());
			
			//If the file exists, the program asks the user to enter songs. If not, the program asks the user whether to create a file with the name that was entered.
			boolean shouldContinue;
			
			if (file.exists()) {
				shouldContinue = true;
			} 
			else {
				shouldContinue = getYN(input, "This file does not exist right now. Would you like to create a file with this name?");
			}

			if (shouldContinue) {
				try (
						ObjectOutputStream out = new ObjectOutputStream(
												new BufferedOutputStream(
												new FileOutputStream(file)));
				) {
					int songCount = 1; //This counts the number of songs entered.
					boolean shouldAsk = true;
					
					while (shouldAsk) { //The while loop keeps asking the user to enter songs until they don't want to anymore.
						System.out.print("\nWhat is the title of song #" + songCount + "? ");
						String title = input.nextLine();
						System.out.print("Who is the artist? ");
						String artist = input.nextLine();
						System.out.print("What is the genre? ");
						String genre = input.nextLine();
						
						Date releaseDate = new Date();
						changeDate(input, releaseDate);
						
						//A Song object is created using the attributes entered by the user. It is serialized and written to the file.
						Song song = new Song(title, artist, genre, releaseDate);
						out.writeObject(song);
						
						songCount++;
						shouldAsk = getYN(input, "\nWould you like to enter another song? ");
					}
				}
			}
		}
	}

	public static boolean getYN(Scanner input, String question) { //This method is used for two yes-or-no questions.
		while (true) {
			System.out.print(question + " Please enter yes (y) or no (n): ");
			String answer = input.nextLine();
			
			switch (answer) {
				case "yes":
				case "y":
					return true;
				case "no":
				case "n":
					return false;
				default:
					System.out.println("Sorry, your answer was invalid.");
			}
		}
	}

	public static void changeDate(Scanner input, Date releaseDate) {
		while (true) {
		/*Because of this try-catch block, the program will start over with asking you for the month of the release date 
		 * if you enter something invalid while one of the "edit" methods from the Date class is being invoked. 
		 * I decided this wasn't a big problem because you're only entering 3 numbers after all. */
			try {
				//I set m, d, and y all to 1, so when m is first set, the setDate method won't ask the user to re-enter d and y (1 is a valid value for all three data fields.)
				int m = 1;
				int d = 1;
				int y = 1;
				
				System.out.print("\n");
				m = releaseDate.editMonth(getMDY(input, "month"));
				releaseDate.setDate(m, d, y); //The validity of d depends on the value of m, so the date is set with the new m here.
				d = releaseDate.editDay(getMDY(input, "day"));
				y = releaseDate.editYear(getMDY(input, "year"));
				
				releaseDate.setDate(m, d, y);
				input.nextLine();
				return;
			} 
			catch (InputMismatchException ex) {
				input.nextLine();
			}
		}
	}
	
	public static int getMDY(Scanner input, String mdy) { //This method is used in the changeDate method.
		while (true) {
			System.out.print("What is the " + mdy + " of the release date, as a number? ");
			
			try {
				return input.nextInt();
			} 
			catch (InputMismatchException ex) {
				System.out.println("Sorry, your answer was invalid.");
				input.nextLine(); //The Scanner is still storing the user's invalid answer, so I used nextLine() to clear it.
			}
		}
	}
}
