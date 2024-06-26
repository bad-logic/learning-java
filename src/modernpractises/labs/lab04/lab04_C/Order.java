package modernpractises.labs.lab04.lab04_C;

import java.time.LocalDate;

public class Order {
	private String orderNo;
	private LocalDate orderDate;
	private double orderAmount;
	
	Order(String orderNo, LocalDate orderDate, double orderAmount) {
		this.orderNo = orderNo;
		this.orderDate = orderDate;
		this.orderAmount = orderAmount;
	}
	
	public double getOrderAmount() {
		return this.orderAmount;
	}
	
	public LocalDate getOrderDate() {
		return this.orderDate;
	}
}
