package modernpractises.labs.lab04.lab04_C;

public class Hourly extends Employee{
	private double hourlyWage;
	private double hoursPerWeek;
	
	Hourly(String empId, double hoursPerWeek, double hourlyWage) {
		super(empId);
		this.hoursPerWeek = hoursPerWeek;
		this.hourlyWage = hourlyWage;
	}
	
	public double calcGrossPay(int month, int year) {
		return hourlyWage * hoursPerWeek * 4;
	}
	
}
