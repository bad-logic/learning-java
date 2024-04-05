package modernpractises.labs.lab04.lab04_C;

public class Salaried extends Employee{
	private double salary;
	
	Salaried(String empId, double salary) {
		super(empId);
		this.salary = salary;
	}
	
	public double calcGrossPay(int month, int year) {
		return salary;
	}
}
