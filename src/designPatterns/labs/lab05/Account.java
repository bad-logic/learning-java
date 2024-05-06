package designPatterns.labs.lab05;

import designPatterns.labs.lab05.commands.Command;
import designPatterns.labs.lab05.commands.Invoker;
import designPatterns.labs.lab05.commands.NoCommand;

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
	private double lastAmount;
	private String lastDescription;

	public Account(String accountNumber) {
		this.accountNumber = accountNumber;
		this.cmd = new NoCommand();

		this.lastCommand = new NoCommand();
		this.lastAmount = 0.0;
		this.lastDescription = "";
	}

	public void setCommand(Command cmd){
		this.cmd = cmd;
	}

	@Override
	public void execute(double amount, String description) {
		// save for redo or undo
		this.lastCommand = this.cmd;
		this.lastDescription = description;
		this.lastAmount = amount;

		this.cmd.execute(this,amount,description);
		// clean slate for next operation
		// if not set throws error so client knows cmd must be set
		this.cmd = null;
	}

	@Override
	public void redo(){
		this.lastCommand.redo(this,this.lastAmount,this.lastDescription);
	}

	@Override
	public void undo(){
		this.lastCommand.undo(this,this.lastAmount,this.lastDescription);
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
