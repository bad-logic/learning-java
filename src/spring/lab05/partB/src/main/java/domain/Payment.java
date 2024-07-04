package domain;


import jakarta.persistence.Embeddable;

@Embeddable
public class Payment {

	private String paydate;
	private double amount;

	public Payment() {
	}

	public Payment(String payDate, double amount) {
		this.paydate = payDate;
		this.amount = amount;
	}

	public String getPayDate() {
		return paydate;
	}

	public void setPayDate(String payDate) {
		this.paydate = payDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Payment{" +
				"paydate='" + paydate + '\'' +
				", amount=" + amount +
				'}';
	}
}
