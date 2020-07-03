package unit2;

public class Car extends Vehicle {
	private int year_;
	private String make_;
	
	public Car (int year, String make) {
		year_ = year;
		make_ = make;
	}
	public int getYear() {
		return year_;
	}
	public String getMake() {
		return make_;
	}
	
	//No setters because a car's make and model year will never change
	
	@Override
	public void display() { //Car overrides the abstract method in Vehicle with its own version.
		System.out.println("Car");
		System.out.println("Year: " + year_);
		System.out.println("Make: " + make_);
	}
}