package unit3;

public class Car extends Vehicle {
	public Car() {
		super();
	}
	
	public Car(String make, int year) {
		super(make, year);
	}
	
	@Override
	public void makeSound() {
		System.out.println("Car: honk honk");
	}
}
