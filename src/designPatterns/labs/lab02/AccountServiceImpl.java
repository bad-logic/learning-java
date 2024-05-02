package designPatterns.labs.lab02;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AccountServiceImpl implements AccountService {
	private AccountDAO accountDAO;
	private List<Observer> observersList = new ArrayList<Observer>();
	
	public AccountServiceImpl(){
		accountDAO = new AccountDAOImpl();
	}

	public Account createAccount(String accountNumber, String customerName) {
		Account account = new Account(accountNumber);
		Customer customer = new Customer(customerName);
		account.setCustomer(customer);
		
		accountDAO.saveAccount(account);

		// dispatch account created events
		this.notifyObservers(Event.ACCOUNT_CREATION);

		return account;
	}

	public void deposit(String accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		account.deposit(amount);
		
		accountDAO.updateAccount(account);

		// dispatch account change events
		this.notifyObservers(Event.ACCOUNT_CHANGE);
	}

	public Account getAccount(String accountNumber) {
		Account account = accountDAO.loadAccount(accountNumber);
		return account;
	}

	public Collection<Account> getAllAccounts() {
		return accountDAO.getAccounts();
	}

	public void withdraw(String accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		account.withdraw(amount);
		accountDAO.updateAccount(account);

		// dispatch account change events
		this.notifyObservers(Event.ACCOUNT_CHANGE);
	}


	public void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description) {
		Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
		Account toAccount = accountDAO.loadAccount(toAccountNumber);
		fromAccount.transferFunds(toAccount, amount, description);
		accountDAO.updateAccount(fromAccount);
		accountDAO.updateAccount(toAccount);

		// dispatch account change events
		this.notifyObservers(Event.ACCOUNT_CHANGE);
	}

	/**
	 * @param observer
	 */
	@Override
	public void registerObserver(Observer observer) {
		this.observersList.add(observer);
	}

	/**
	 * @param observer
	 */
	@Override
	public void removeObserver(Observer observer) {
		this.observersList.remove(observer);
	}


	private void notifyObservers(Event event) {
		for(Observer obs: this.observersList){
			obs.callBack(event);
		}
	}
}
