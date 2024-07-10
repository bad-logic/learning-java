package bank.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class AccountEntry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private LocalDateTime date;
	private double amount;
	private String description;
	private String fromAccountNumber;
	private String fromPersonName;
	
	public AccountEntry() {
	}

	public AccountEntry(LocalDateTime date, double amount, String description, String fromAccountNumber, String fromPersonName) {
		this.date = date;
		this.amount = amount;
		this.description = description;
		this.fromAccountNumber = fromAccountNumber;
		this.fromPersonName = fromPersonName;
	}

	public long getId() {
		return id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFromAccountNumber() {
		return fromAccountNumber;
	}

	public void setFromAccountNumber(String fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}

	public String getFromPersonName() {
		return fromPersonName;
	}

	public void setFromPersonName(String fromPersonName) {
		this.fromPersonName = fromPersonName;
	}

	@Override
	public String toString() {
		return "AccountEntry{" +
				"amount=" + amount +
				", id=" + id +
				", date=" + date +
				", description='" + description + '\'' +
				", fromAccountNumber='" + fromAccountNumber + '\'' +
				", fromPersonName='" + fromPersonName + '\'' +
				'}';
	}
}
