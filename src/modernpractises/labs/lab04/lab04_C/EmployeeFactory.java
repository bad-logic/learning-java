package modernpractises.labs.lab04.lab04_C;

import java.time.LocalDate;
import java.util.List;

public class EmployeeFactory {
	public static Commissioned createCommissioned(String empId, double commission, double baseSalary, List<Order> order) {
		return new Commissioned(empId, commission, baseSalary, order);
	}
	
	public static Salaried createSalaried(String empId, double salary) {
		return new Salaried(empId, salary);
	}
	
	public static Hourly createHourly(String empId, double hoursPerWeek, double hourlyWage) {
		return new Hourly(empId, hoursPerWeek, hourlyWage);
	}
	
	public static Order createOrder(String orderNo, LocalDate orderDate, double orderAmount) {
		return new Order(orderNo, orderDate, orderAmount);
	}
}

