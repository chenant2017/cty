package unit1;

public class Employee {
	private String name_;
	private Date hireDate_;
	
	public Employee(String name, Date hireDate) {
		name_ = name;
		hireDate_ = hireDate;
	}
	
	public String getName() {
		return name_;
	}
	
	public Date getHireDate() {
		return hireDate_;
	}
	
	public String setName(String newName) {
		return newName;
	}
	
	public void setHireDate(int m, int d, int y) {
		hireDate_.setDate(m, d, y);
	}
}

