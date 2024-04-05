package modernpractises.labs.lab04.lab04_C;

import java.time.LocalDate;
import java.util.List;

public class Commissioned extends Employee{
	private double commission;
	private double baseSalary;
	private List<Order> order;
	
	Commissioned(String empid, double commission, double baseSalary, List<Order> order){
		super(empid);
		this.commission = commission;
		this.baseSalary = baseSalary;
		this.order = order;
	}
	
	public double calcGrossPay(int month, int year) {
		return baseSalary + (commission * totalValueOfAllOrder(month, year));
	}
	
	
	private double totalValueOfAllOrder(int month, int year) {
		double total = 0;
		for(Order ord: order) {
			if (isPreviousMonth(month, year, ord)) {
				total += ord.getOrderAmount();								
			}
		}		
		return total;
	}
	
	private boolean isPreviousMonth(int month, int year, Order order) {
		int previousMonth = month - 1;
		int previousYear = year;
		LocalDate orderDate = order.getOrderDate();
		
		if (previousMonth == 12) {
			previousYear--;
		}
		
		return (orderDate.getMonthValue() < month && orderDate.getYear() == previousYear);
	}
}
