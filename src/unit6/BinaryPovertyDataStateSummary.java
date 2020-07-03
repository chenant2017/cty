package unit6;

import java.io.*;
import java.util.Scanner;

public class BinaryPovertyDataStateSummary {
	static class State { //Same idea as program for Assignment 5; there is a State class
		private int totalPopulation_;
		private int childPopulation_;
		private int childPovertyPopulation_;

		public State() {
			reset(); 
		}

		public void writeNumbers(String stateCode, DataOutputStream out) throws IOException {
			//Using DataOutputStream methods to write into binary file
			out.writeUTF(stateCode); 
			out.writeInt(totalPopulation_);
			out.writeInt(childPopulation_);
			out.writeInt(childPovertyPopulation_);
		}

		public void reset() {
			totalPopulation_ = 0;
			childPopulation_ = 0;
			childPovertyPopulation_ = 0;
		}

		public void updatePopulations(String section) { 
			try ( 
					Scanner populationScanner = new Scanner(section);
				) {
				totalPopulation_ += populationScanner.nextInt();
				childPopulation_ += populationScanner.nextInt();
				childPovertyPopulation_ += populationScanner.nextInt();
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		try (
				BufferedReader in = new BufferedReader( 
									new FileReader(
									new File("/Users/anthony/java/cty2/src/unit6/PovertyDataCopy.txt")));
				
				DataOutputStream out = new DataOutputStream(
										new BufferedOutputStream(
										new FileOutputStream("/Users/anthony/java/cty2/src/unit6/PovertyDataStateSummary.dat"))); 
		) {
			State state = new State();
			String stateCode = "";
			
			while (true) {
				String line = in.readLine();
				
				if (line == null) {
					break;
				}
				
				String newStateCode = line.substring(0, 2);
				
				if(!stateCode.equals(newStateCode)) {
					if (stateCode != "") { 
						state.writeNumbers(stateCode, out);
					}
					stateCode = newStateCode;
					state.reset(); 				
				}
				state.updatePopulations(line.substring(84, 108));
			}
			state.writeNumbers(stateCode, out); 
			System.out.println("Done.");  
		}
	}
}
