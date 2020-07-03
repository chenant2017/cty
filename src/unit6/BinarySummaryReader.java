package unit6;

import java.io.*;

public class BinarySummaryReader {
	public static void main(String[] args) throws IOException {
		try (
				DataInputStream in = new DataInputStream(
									new FileInputStream("/Users/anthony/java/cty2/src/unit6/PovertyDataStateSummary.dat"));
		){
			String headers = "|State Code | Total Population | Child Population | Child Poverty Population|"; //Headers of the table
			
			//Prints the top edge of the table
			System.out.print(" ");
			
			for (int i = 0; i < headers.length() - 2; i++) {
				System.out.print("_");
			}
			System.out.println();
			System.out.println(headers);
			
			String[] headersArray = headers.split("\\|"); //Array of the headers; used for formatting
			printCellBorders(headersArray); //Prints the rest of the borders for the top row of cells
			printData(in, headersArray); //Prints the rest of the table
		}
	}
	
	public static void printCellBorders(String[] array) {
		//Prints underscores until it reaches the end of the cell, where a vertical line is printed instead
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length(); j++) {
				System.out.print("_");
			}
			if (i < array.length - 1) {
				System.out.print("|"); 
			}
		}
		//Prints a vertical line at the end.
		System.out.print("|");
	}
	
	public static void printData(DataInputStream in, String[] array) throws IOException { 
		while (true) {
			try {
				System.out.println();
				String s = in.readUTF();
				//Data is printed after the state code is read. Otherwise, an unwanted vertical line will be printed before "in" reaches the end of the file
				System.out.print("|");
				System.out.printf("%-11s", s);
				System.out.print("|");
				System.out.printf("%-18d", in.readInt());
				System.out.print("|");
				System.out.printf("%-18d", in.readInt());
				System.out.print("|");
				System.out.printf("%-25d", in.readInt());
				System.out.println("|");
				printCellBorders(array);
			}
			catch (EOFException ex){
				return; //Ends the program after the file has been read completely
			}
		}
	}
}
