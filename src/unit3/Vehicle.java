package unit3;

public abstract class Vehicle implements Sounds {
	private String make_;
	private int year_;
	
	protected Vehicle() {
		make_ = "";
		year_ = 0;
	}
	
	protected Vehicle(String make, int year) {
		make_ = make;
		year_ = year;
	}
	
	public String getMake() {
		return make_;
	}
	
	public int getYear() {
		return year_;
	}
	
	public String setMake(String make) {
		return make;
	}
	
	public void setYear(int year) {
		year_ = year;
	}
	
	@Override
	public void makeSound() {
		System.out.println("This vehicle doesn't make a sound.");
	}
}
