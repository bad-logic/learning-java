package modernpractises.labs.lab04.lab04_C;

abstract public class Employee {
	private String empId;
	
	Employee(String empId) {
		this.empId = empId;
	}
	
	public void print(int month, int year) {
		System.out.println("Employee Id: " + empId);
		System.out.println(calcCompensation(month, year));
	}
	
	public Paycheck calcCompensation(int month, int year) {
		return new Paycheck(calcGrossPay(month, year), 23, 5, 1, 3, 7.5);
	}
	
	abstract public double calcGrossPay(int month, int year);
}
