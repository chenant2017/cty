package unit1;

public class EmployeeTest {
	public static void main(String[] args) {
		int employeeCount = -1; //Give employeeCount an invalid value
		
		while (employeeCount <= 0) { //Keep asking while employeeCount has an invalid value
			employeeCount = Input.getInt("How many employees are you entering information for?");
			if (employeeCount <= 0) {
				System.out.println("Sorry, you must enter a positive integer.");
			}
		}
		
		Employee[] employees = new Employee[employeeCount]; //The array of employees
		
		for (int i = 0; i < employees.length; i++) {
			
			String name = Input.getString("What is employee #" + (i + 1) + "'s name?");
			
			int hireMonth = Input.getInt("In what month was " + name + " hired (as an integer) ?");
			int hireDay = Input.getInt("What day was " + name + " hired (as an integer?");
			int hireYear = Input.getInt("What year was " + name + " hired?");
			Date hireDate = new Date(hireMonth, hireDay, hireYear); //Create Date object with month, day, and year given by the user
			employees[i] = new Employee(name, hireDate); //Declare and initialize an Employee object with the name and hire date
			
			int employeeType = 0; //Give employeeType an invalid value
			
			while (employeeType != 1 && employeeType !=2) { //Keep asking while employeeType has an invalid value.
				employeeType = Input.getInt("Is " + name + " an hourly employee (1) or salaried employee (2)?");
				switch(employeeType) { //Do appropriate actions for user's choice
					case 1:
						float wage = 0;
						while (wage <= 0) {
							wage = Input.getFloat("What is " + name + "'s hourly wage, in dollars?");
							if (wage <= 0) {
								System.out.println("Sorry, you must enter a positive wage.");
							}
						}
						float hoursWorked = -1;
						while (hoursWorked < 0) {
							hoursWorked = Input.getFloat("How many hours has " + name + " worked?");
							if (hoursWorked < 0) {
								System.out.println("Sorry, you must enter a nonnegative number of hours.");
							}
						}
						employees[i] = new HourlyEmployee(employees[i].getName(), employees[i].getHireDate(), wage, hoursWorked); //Replace the Employee object with an HourlyEmployee object
						break;
					case 2:
						float salary = 0;
						while (salary <= 0) {
							salary = Input.getFloat("What is " + name + "'s salary?");
							if (salary <= 0) {
								System.out.println("Sorry, you must enter a positive salary.");
							}
						}
						employees[i] = new SalariedEmployee(employees[i].getName(), employees[i].getHireDate(), salary); //Replace Employee object with a SalariedEmployee object
						break;
					default:
						System.out.println("Sorry, you must enter 1 or 2.");
				}
			}
		}
		for (int i = 0; i < employees.length; i++) { //Prints out the information for all the employees after everything is entered
			System.out.println("\nEmployee #" + (i + 1));
			System.out.println("Name: " + employees[i].getName());
			if (employees[i] instanceof HourlyEmployee) {
				System.out.println("Hourly wage: " + ((HourlyEmployee) employees[i]).getWage());
				System.out.println("Hours worked: " + ((HourlyEmployee) employees[i]).getHoursWorked());
			}
			else {
				System.out.println("Salary: " + ((SalariedEmployee) employees[i]).getSalary());
			}
			System.out.println("Hire date: " + employees[i].getHireDate().getDate());
		}
	}
}