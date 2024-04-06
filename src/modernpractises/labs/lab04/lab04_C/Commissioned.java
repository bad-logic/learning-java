package modernpractises.labs.lab04.lab04_C;

import java.time.LocalDate;
import java.util.List;

public class Commissioned extends Employee{
	private double commission;
	private double baseSalary;
	private List<Order> orders;
	
	Commissioned(String empId, double commission, double baseSalary, List<Order> order){
		super(empId);
		this.commission = commission;
		this.baseSalary = baseSalary;
		this.orders = order;
	}

	public void addOrders(List<Order> orders){
		this.orders.addAll(this.orders.size(),orders);
	}

	public List<Order> getOrders(){
		return this.orders;
	}

	public double calcGrossPay(int month, int year) {
		return this.baseSalary + (this.commission * getTotalValueOfAllOrder(month, year));
	}
	
	
	private double getTotalValueOfAllOrder(int month, int year) {
		double total = 0;
		for(Order ord: this.orders) {
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

		return (orderDate.getMonthValue() == previousMonth && orderDate.getYear() == previousYear);
	}
}
