package unit2;

public abstract class Vehicle { //The abstract method display is in Vehicle so that it can be overridden by Boat and Car.
	protected abstract void display(); //Method is protected because I only want Boat and Car to be able to access it.
}