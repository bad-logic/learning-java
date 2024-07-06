package app;

import jakarta.persistence.*;

@Entity
public class Account {
	@Id
	@GeneratedValue
	private Long accountNumber;

	private double balance;

	@OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id")
	private Customer customer;

	public Account() {
	}

	public Account(double balance, Customer customer) {
		this.balance = balance;
		this.customer = customer;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account{" +
				"accountNumber=" + accountNumber +
				", customer=" + customer +
				'}';
	}
}
