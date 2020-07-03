package unit2;

import java.util.Scanner;

public class VehicleTest {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int length = 0;
		while (length <= 0) { //Length should be positive
			System.out.print("How many vehicles would you like to enter? ");
			length = input.nextInt();
			if (length <= 0) { 
				System.out.println("Sorry, answer invalid.");
			}
		}
			
		Vehicle[] vehicles = new Vehicle[length]; //Array created with desired length
		
		for (int i = 0; i < vehicles.length; i++) { //Each element of the array becomes either a Car or Boat object
			int answer = 0;
			while (answer != 1 && answer != 2) { //Ask again if answer was invalid
				System.out.print("\nIs vehicle " + (i + 1) + " a car (1) or boat (2)? ");
				answer = input.nextInt();
				//Asking for user input on the attributes of each object
				switch(answer) {
					case 1:
						System.out.print("What is the car's model year? ");
						int year = input.nextInt();
						System.out.print("What is the car's make? ");
						String make = input.next();
						vehicles[i] = new Car(year, make);
						break;
					case 2:
						System.out.print("What is the boat's length, in feet? ");
						float boatLength = input.nextFloat();
						System.out.print("What is the boat's draft, in feet? ");
						float draft = input.nextFloat();
						vehicles[i]= new Boat(boatLength, draft);
						break;
					default:
						System.out.println("Sorry, answer invalid.");
				}
			}
		}
		//Display each object's information
		for (int i = 0; i < vehicles.length; i++) {
			System.out.print("\nVehicle " + (i + 1) + ": ");
			vehicles[i].display();
		}
	}
}