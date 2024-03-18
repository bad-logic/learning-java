package fundamentals.labs.lab10;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee {

	private String name;
	private Date hireDate;
	private double salary;
	
	public Employee(String name, double salary, int year, int month, int day){
		this.name = name;
		this.salary = salary;
		GregorianCalendar cal = 
			new GregorianCalendar(year,month,day);
		hireDate= cal.getTime();
	}

	public Date getHireDate() {
		return (Date)hireDate.clone();
	}
	public String getName() {
		return name;
	}
	public double getSalary() {
		return salary;
	}
	public boolean equals(Object o){
		final double SAL_TOLERANCE = 0.00000001;
		if(o==null) return false;
		if(o.getClass() != this.getClass()) {
			return false;
		}
		Employee e = (Employee)o;
		return (e.getName().equals(name)&& 
				e.getHireDate().equals(hireDate) &&
				Math.abs(e.getSalary() - salary) < SAL_TOLERANCE);
	}
	
	public int hashCode(){
		return name.hashCode() + 
				5*((int)Math.round(salary)) +
				5 * 5 * hireDate.hashCode();
	}

	public String toString() {
		String newline = System.getProperty("line.separator");
		return newline+"EMPLOYEE "+name+newline+
				"Date of Hire: "+hireDate+newline+
				"Salary: "+salary+newline;
	}

	

}

