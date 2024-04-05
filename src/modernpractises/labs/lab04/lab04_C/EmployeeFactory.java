package modernpractises.labs.lab04.lab04_C;

import java.time.LocalDate;
import java.util.List;

public class EmployeeFactory {
	public static Commissioned createCommissioned(String empid, double commission, double baseSalary, List<Order> order) {
		Commissioned newCommissioned = new Commissioned(empid, commission, baseSalary, order);
		return newCommissioned;
	}
	
	public static Salaried createSalaried(String empId, double salary) {
		Salaried newSalaried = new Salaried(empId, salary);
		return newSalaried;
	}
	
	public static Hourly createHourly(String empId, double hoursPerWeek, double hourlyWage) {
		Hourly newHourly = new Hourly(empId, hoursPerWeek, hourlyWage);
		return newHourly;
	}
	
	public static Order createOrder(String orderNo, LocalDate orderDate, double orderAmount) {
		Order newOrder = new Order(orderNo, orderDate, orderAmount);
		return newOrder;
	}
}
