package unit3;

public class Boat extends Vehicle {
	public Boat() {
		super();
	}
	
	public Boat(String make, int year) {
		super(make, year);
	}
	
	@Override
	public void makeSound() {
		System.out.println("Boat: toot toot");
	}
}
