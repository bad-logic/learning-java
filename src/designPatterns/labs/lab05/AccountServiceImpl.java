package designPatterns.labs.lab05;

import designPatterns.labs.lab05.commands.*;
import java.util.Collection;

public class AccountServiceImpl implements AccountService {
	private AccountDAO accountDAO;

	public AccountServiceImpl(){
		accountDAO = new AccountDAOImpl();
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

		// set deposit command
		Command deposit = new DepositCommand();
		account.setCommand(deposit);

		account.execute(amount,"Deposit");
		accountDAO.updateAccount(account);
	}

	public void withdraw(String accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);

		// set withdraw command
		Command withdraw = new WithdrawCommand();
		account.setCommand(withdraw);

		account.execute(amount,"Withdraw");
		accountDAO.updateAccount(account);
	}

	public void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description) {
		Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
		Account toAccount = accountDAO.loadAccount(toAccountNumber);

		// set transfer command
		Command transfer = new TransferFundsCommand(toAccount);
		fromAccount.setCommand(transfer);

		fromAccount.execute(amount, description);
		accountDAO.updateAccount(fromAccount);
		accountDAO.updateAccount(toAccount);
	}

	public void redoLastTransaction(String accountNumber){
		Account account = accountDAO.loadAccount(accountNumber);
		account.redo();
	}

	public void undoLastTransaction(String accountNumber){
		Account account = accountDAO.loadAccount(accountNumber);
		account.undo();
	}

	public Account getAccount(String accountNumber) {
		Account account = accountDAO.loadAccount(accountNumber);
		return account;
	}

	public Collection<Account> getAllAccounts() {
		return accountDAO.getAccounts();
	}
}
