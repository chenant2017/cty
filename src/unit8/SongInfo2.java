package unit8;

import java.io.*;
import java.util.*;

public class SongInfo2 { 
	/* You can make instances of this class. The TreeMap object is the only data field.
	 * The keys of map_ are String objects that include the titles and artists of the songs. 
	 * The values are Song objects.*/
	private TreeMap<String, Song> map_; 
	
	public SongInfo2() {
		map_ = new TreeMap<>(); //Because of type inference, nothing is needed in <>.             
	}
	
	public void initializeMap(File file) throws IOException, ClassNotFoundException {
		/* A file can be read if it exists and is not empty.
		 * If this is the case, the program attempts to read a map from the file.*/
		if (file.canRead()) {
			try (
					ObjectInputStream in = new ObjectInputStream(
											new BufferedInputStream(
											new FileInputStream(file)))
			) {
				map_ = (TreeMap<String, Song>) in.readObject(); //There is unchecked casting here but it seems like I cannot avoid doing this.
			}
		}
	}
	
	public void add() {
		/* The Scanner is never closed. 
		 * When I attempted to close it, the program threw a NoSuchElementException.
		 * I think this is because closing the Scanner also closed the stream from System.in.*/
		Scanner input = new Scanner(System.in); 
		boolean shouldAsk = true;
		
		while (shouldAsk) { 
			System.out.print("\nWhat is the title of the song you would like to add? ");
			String title = input.nextLine();
			System.out.print("Who is the artist? ");
			String artist = input.nextLine();
			System.out.print("What is the genre? ");
			String genre = input.nextLine();
			Date releaseDate = new Date();
			changeDate(releaseDate);
			
			Song song = new Song(title, artist, genre, releaseDate);
			map_.put("\"" + title + "\"" + " by " + artist, song); //The song title is in quotation marks, followed by the artist
			
			shouldAsk = getYN("\nWould you like to enter another song? ");
		}
	}
	
	public void remove() {
		Scanner input = new Scanner(System.in);
		boolean shouldAsk = true;
		
		while (shouldAsk) {
			System.out.print("\nWhat is the title of the song you would like to remove? ");
			String title = input.nextLine();
			System.out.print("Who is the artist? ");
			String artist = input.nextLine();
			
			String key = "\"" + title + "\"" + " by " + artist;
			
			if (map_.containsKey(key)) {
				map_.remove(key); //Removes the song
			}
			else {
				System.out.println("This song is not in the file.");
			}
			
			shouldAsk = getYN("\nWould you like to remove another song? ");
		}
	}
	
	public void display() {
		if (map_.isEmpty()) {
			System.out.println("\nThere are no songs.");
		}
		else {
			Set<Map.Entry<String, Song>> songSet = map_.entrySet(); //Creates a set of all entries in the TreeMap
			int count = 1; //Used to to number the songs
			
			for (Map.Entry<String, Song> entry: songSet) {
				System.out.println("\n" + count + ". " + entry.getKey());
				System.out.println("Genre: " + entry.getValue().getGenre());
				System.out.println("Release Date: " + entry.getValue().getReleaseDate().getDate());
				count++;
			}
		}
	}
	
	public static void changeDate(Date releaseDate){
		while (true) {
			try {
				int m = 1;
				int d = 1;
				int y = 1;
				
				System.out.print("\n");
				m = getMDY("month");
				d = getMDY("day");
				y = getMDY("year");
				
				releaseDate.setDate(m, d, y);
				return;
			} 
			catch (InputMismatchException ex) {
				System.out.println("Please try again.");
			}
		}
	}
	
	public static int getMDY(String mdy) { 
		Scanner input = new Scanner(System.in);
		
		while (true) {
			System.out.print("What is the " + mdy + " of the release date, as a number? ");
			String answer = input.nextLine();
			
			try {
				return Integer.parseInt(answer); 
			}
			catch (NumberFormatException ex) {
				System.out.println("Please try again.");
			} 
		}
	}
	
	public static boolean getYN(String question) {
		Scanner input = new Scanner(System.in);
		
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
					System.out.println("Please try again.");
			}
		}
	}
	
	/* When the user is adding/removing/displaying songs, the program is interacting with the TreeMap object, not the file.
	 * This method is used to finally write the updated map to the file when the user quits. */
	public void writeToFile(File file) throws IOException {
		try (
				ObjectOutputStream out = new ObjectOutputStream(
										new BufferedOutputStream(
										new FileOutputStream(file)));
		) {
			out.writeObject(map_);
		}
	}
	
	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in);) {
			System.out.println("Please enter the name of the file you would like to use.");
			System.out.println("Note: if the file doesn't exist, it will be created: ");
			File file = new File(input.nextLine());
			SongInfo2 songInfo = new SongInfo2(); //The constructor creates an empty TreeMap object.
			
			
			try {
				songInfo.initializeMap(file); //If there is any data already in the file, this method will create a map with the data. 
			}
			catch (Exception ex) {
				System.out.println("An error occured.");
				System.exit(1);;
			}
			
			while (true) {
				System.out.println("\n            MENU");
				for (int i = 1; i <= 28; i++) {
					System.out.print("_");
				}
				
				System.out.println("\n 1. Add a song\n 2. Remove a song\n 3. Display songs\n 4. Save and quit");
				System.out.print("\nPlease enter the number of your choice: ");
				String answer = input.nextLine();
				int choice = 0;
				
				try {
					choice = Integer.parseInt(answer);
				}
				catch (Exception ex) {
					System.out.println("Please try again.");
					continue; //If the user enters something invalid, the program goes back to the start of the loop.
					
				} 
				
				switch (choice) {
					case 1:
						songInfo.add();
						break;
					case 2:
						songInfo.remove();
						break;
					case 3:
						songInfo.display();
						break;
					case 4:
						try {
							songInfo.writeToFile(file);
							System.out.println("Have a nice day.");
							System.exit(0);
						}
						catch (IOException ex) {
							System.out.println("Sorry, data could not be written to the file.");
							System.exit(1);
						}
					default:
						System.out.println("Please try again.");
				}
			}	
		}
	}
}