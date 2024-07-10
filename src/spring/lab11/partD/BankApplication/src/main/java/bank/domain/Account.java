package bank.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.*;

@Entity
public class Account {

	@Id
	@GeneratedValue
	private long accountnumber;

	@OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name = "account_id")
	Collection<AccountEntry> entryList = new ArrayList<AccountEntry>();

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "customer_id")
	Customer customer;

	public Account(){}
	
	public Account (long accountnr){
		this.accountnumber = accountnr;
	}

	public long getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(long accountnumber) {
		this.accountnumber = accountnumber;
	}

	public double getBalance() {
		double balance=0;
		for (AccountEntry entry : entryList) {
			balance+=entry.getAmount();
		}
		return balance;
	}

	public void deposit(double amount){
		AccountEntry entry = new AccountEntry(LocalDateTime.now(), amount, "deposit", "", "");
		entryList.add(entry);
	}

	public void withdraw(double amount){
		AccountEntry entry = new AccountEntry(LocalDateTime.now(), -amount, "withdraw", "", "");
		entryList.add(entry);	
	}

	private void addEntry(AccountEntry entry){
		entryList.add(entry);
	}

	public void transferFunds(Account toAccount, double amount, String description){
		AccountEntry fromEntry = new AccountEntry(LocalDateTime.now(), -amount, description, ""+toAccount.getAccountnumber(), toAccount.getCustomer().getName());
		AccountEntry toEntry = new AccountEntry(LocalDateTime.now(), amount, description, ""+toAccount.getAccountnumber(), toAccount.getCustomer().getName());
		entryList.add(fromEntry);	
		toAccount.addEntry(toEntry);
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Collection<AccountEntry> getEntryList() {
		return entryList;
	}

	@Override
	public String toString() {
		return "Account{" +
				", accountnumber=" + accountnumber +
				", entryList=" + entryList +
				", customer=" + customer +
				'}';
	}
}
