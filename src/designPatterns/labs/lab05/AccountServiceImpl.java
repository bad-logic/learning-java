package designPatterns.labs.lab05;

import designPatterns.labs.lab05.commands.*;
import java.util.Collection;

public class AccountServiceImpl implements AccountService {
	private AccountDAO accountDAO;

	private Command cmd;
	private Command lastCommand;


	public AccountServiceImpl(){
		accountDAO = new AccountDAOImpl();
		this.lastCommand = new NoCommand();
		this.cmd = new NoCommand();
	}

	public Account createAccount(String accountNumber, String customerName) {
		Account account = new Account(accountNumber);
		Customer customer = new Customer(customerName);
		account.setCustomer(customer);
		
		accountDAO.saveAccount(account);
		
		return account;
	}

	public Account getAccount(String accountNumber) {
		Account account = accountDAO.loadAccount(accountNumber);
		return account;
	}

	public Collection<Account> getAllAccounts() {
		return accountDAO.getAccounts();
	}

	@Override
	public void setCommand(Command cmd) {
		this.cmd = cmd;
	}

	@Override
	public void execute() {
		this.cmd.execute();
		this.lastCommand = this.cmd;
		// resetting the command after using
		this.cmd = new NoCommand();
	}

	@Override
	public void redo() {
		this.lastCommand.redo();
	}

	@Override
	public void undo() {
		this.lastCommand.undo();
	}
}
