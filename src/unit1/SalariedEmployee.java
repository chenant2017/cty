package unit1;

public class SalariedEmployee extends Employee { //Subclass of Employee
	private float salary_; //Has the special attribute salary_
	
	public SalariedEmployee(String name, Date hireDate, float salary) {
		super(name, hireDate);
		salary_ = salary;
	}
	
	public float getSalary() {
		return salary_;
	}
}