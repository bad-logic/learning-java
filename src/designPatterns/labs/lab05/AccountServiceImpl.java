package designPatterns.labs.lab05;

import designPatterns.labs.lab05.commands.*;
import java.util.Collection;

public class AccountServiceImpl implements AccountService {
	private AccountDAO accountDAO;

	private Command lastCommand;

	public AccountServiceImpl(){
		accountDAO = new AccountDAOImpl();
		this.lastCommand = new NoCommand();
	}

	public Account createAccount(String accountNumber, String customerName) {
		Account account = new Account(accountNumber);
		Customer customer = new Customer(customerName);
		account.setCustomer(customer);
		
		accountDAO.saveAccount(account);
		
		return account;
	}

	public void deposit(String accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);

		Command deposit = new DepositCommand(account,amount,"Deposit");
		deposit.execute();

		accountDAO.updateAccount(account);
		this.lastCommand = deposit;
	}

	public void withdraw(String accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);

		Command withdraw = new WithdrawCommand(account,amount,"Withdraw");
		withdraw.execute();

		accountDAO.updateAccount(account);
		this.lastCommand = withdraw;
	}

	public void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description) {
		Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
		Account toAccount = accountDAO.loadAccount(toAccountNumber);

		Command transfer = new TransferFundsCommand(fromAccount,toAccount,amount,description);
		transfer.execute();

		accountDAO.updateAccount(fromAccount);
		accountDAO.updateAccount(toAccount);

		this.lastCommand = transfer;
	}

	public Account getAccount(String accountNumber) {
		Account account = accountDAO.loadAccount(accountNumber);
		return account;
	}

	public Collection<Account> getAllAccounts() {
		return accountDAO.getAccounts();
	}

	/**
	 *
	 */
	@Override
	public void redo() {
		this.lastCommand.redo();
	}

	/**
	 *
	 */
	@Override
	public void undo() {
		this.lastCommand.undo();
	}
}
