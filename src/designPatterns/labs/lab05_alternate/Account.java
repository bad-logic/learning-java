package designPatterns.labs.lab05_alternate;

import designPatterns.labs.lab05_alternate.commands.Command;
import designPatterns.labs.lab05_alternate.commands.Invoker;
import designPatterns.labs.lab05_alternate.commands.NoCommand;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Account implements Invoker {
	private Customer customer;

	private String accountNumber;

	private List<AccountEntry> entryList = new ArrayList<AccountEntry>();

	private Command cmd;

	// last transaction information
	private Command lastCommand;


	public Account(String accountNumber) {
		this.accountNumber = accountNumber;
		this.cmd = new NoCommand();

		this.lastCommand = new NoCommand();
	}

	public void deposit(double amount,String description){
		AccountEntry entry = new AccountEntry(amount, description, "", "");
		entryList.add(entry);
	}

	public void withdraw(double amount,String description) {
		AccountEntry entry = new AccountEntry(-amount, description, "", "");
		entryList.add(entry);
	}

	public void transferFunds(Account toAccount, double amount, String description) {
		AccountEntry fromEntry = new AccountEntry(-amount, description, toAccount.getAccountNumber(),
				toAccount.getCustomer().getName());
		AccountEntry toEntry = new AccountEntry(amount, description, toAccount.getAccountNumber(),
				toAccount.getCustomer().getName());

		entryList.add(fromEntry);

		toAccount.addEntry(toEntry);
	}

	public void setCommand(Command cmd){
		this.cmd = cmd;
	}

	@Override
	public void execute() {
		// save for redo or undo
		this.lastCommand = this.cmd;

		this.cmd.execute();
		// clean slate for next operation
		// if not set throws error so client knows cmd must be set
		this.cmd = null;
	}

	@Override
	public void redo(){
		this.lastCommand.redo();
	}

	@Override
	public void undo(){
		this.lastCommand.undo();
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		double balance = 0;
		for (AccountEntry entry : entryList) {
			balance += entry.getAmount();
		}
		return balance;
	}

	private void addEntry(AccountEntry entry) {
		entryList.add(entry);
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

}
