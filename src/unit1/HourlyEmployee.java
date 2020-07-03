package unit1;

public class HourlyEmployee extends Employee { //Subclass of Employee
	private float wage_; //Has the special attributes wage_ and hoursWorked_
	private float hoursWorked_;
	
	public HourlyEmployee(String name, Date hireDate, float wage, float hoursWorked) {
		super(name, hireDate);
		wage_ = wage;
		hoursWorked_ = hoursWorked;
	}
	
	public float getWage() {
		return wage_;
	}
	
	public float getHoursWorked() {
		return hoursWorked_;
	}
}