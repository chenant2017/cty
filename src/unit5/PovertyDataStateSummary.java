package unit5;

import java.io.*;
import java.util.Scanner;

public class PovertyDataStateSummary {
	/*I thought making a class concerned with the data of each row would make the code more organized and object-oriented.
	It's easier to work with and display the variables when they are all associated with one object.*/
	static class State { 
		private int totalPopulation_;
		private int childPopulation_;
		private int childPovertyPopulation_;

		public State() {
			reset(); //A new State object will have data fields all equal to 0.
		}

		public void displayNumbers(String stateCode, PrintWriter out) {
			//I used some format specifiers to make my data aligned. To make the numbers left-justified, I had to add negative signs.
			out.printf("%-12s", stateCode); 
			out.printf("%-18d", totalPopulation_);
			out.printf("%-18d", childPopulation_);
			out.printf("%-24d\n", childPovertyPopulation_);
		}

		public void reset() {
			totalPopulation_ = 0;
			childPopulation_ = 0;
			childPovertyPopulation_ = 0;
		}

		public void updatePopulations(String section) { //After each row of the source file's data is read, the numbers are updated.
			try ( 
					//I used the try-with-resources syntax so the Scanner will automatically close.
					Scanner populationScanner = new Scanner(section); //The Scanner scans section to get 3 new population numbers.
				) {
				//The populations are updated.
				totalPopulation_ += populationScanner.nextInt();
				childPopulation_ += populationScanner.nextInt();
				childPovertyPopulation_ += populationScanner.nextInt();
			}
		}
	}

	public static void main(String[] args) throws IOException {
		try (
				//I layered classes to make an efficient reader with useful methods.
				BufferedReader in = new BufferedReader( 
				new FileReader(new File("/Users/anthony/java/cty2/src/unit5/PovertyData.txt")));
				
				//I layered classes again to make an efficient writer that could format the text well.
				PrintWriter out = new PrintWriter(new BufferedWriter( 
				new FileWriter("/Users/anthony/java/cty2/src/unit5/PovertyDataStateSummary.txt")));
			) {
			State state = new State();
			String stateCode = "";
			//Titles for each field
			out.print("State Code  ");
			out.print("Total Population  ");
			out.print("Child Population  ");
			out.println("Child Poverty Population\n");
			
			while (true) {
				String line = in.readLine();
				//When there are no more lines to read, the program ends.
				if (line == null) {
					break;
				}
				
				String newStateCode = line.substring(0, 2); //The state code is always the first two characters in each row of the source file.
				
				if (!stateCode.equals(newStateCode)) { 
					if (stateCode != "") { /*During the first iteration of the while loop, stateCode = "" and newStateCode = "01". 
						However, I didn't want a row with "" as the state code, so numbers are only displayed for the state codes that are not "".*/
						state.displayNumbers(stateCode, out);
					}
					//stateCode is updated.
					stateCode = newStateCode;
					state.reset(); //The State object resets its data fields to 0 so it is ready to read the data for the next state code.
				}
				state.updatePopulations(line.substring(84, 108)); //The populations are updated.
			}
			state.displayNumbers(stateCode, out); //I realized that the while loop above did not write the data for the last state code into the file, so I wrote it at the end.
			System.out.println("Done."); //Notifies the user that the program has ended.
		}
	}
}

	