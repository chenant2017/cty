package unit7;

import java.util.Scanner;
import java.io.*;

public class ReadSongInfo {
	public static void main(String[] args) throws Exception {
		try (
				Scanner input = new Scanner(System.in);
		) {
			//If the user enters the name of an existing file, the program will read it. If not, the program ends.
			System.out.print("Please enter the name of the file you would like the program to read from: ");
			File file = new File(input.nextLine());
		
			if (file.exists()) {
				try (ObjectInputStream in = new ObjectInputStream(
											new BufferedInputStream(
											new FileInputStream(file)));
				) {
					int count = 1;
					
					//Each song's information is displayed.
					while (true) {
						try {
							Song song = null;
							song = (Song) in.readObject();
							System.out.println("\nSONG #" + count + ": " + song.getTitle());
							System.out.println("Artist: " + song.getArtist());
							System.out.println("Genre: " + song.getGenre());
							System.out.println("Release Date: " + song.getReleaseDate().getDate());
							count++;
						}
						catch (EOFException ex) {
							return;
						}
					}
				}
			}
			else {
				System.out.println("Sorry, this file doesn't exist.");
			}
		}
	}
}
