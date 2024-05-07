package designPatterns.labs.lab04;


import java.util.Collection;

public class DatabaseAccountDAOImpl implements AccountDAO {


	public void saveAccount(Account account) {

		// your database calls
		System.out.println("DatabaseAccountDAOImpl:saveAccount");
	}

	public void updateAccount(Account account) {
		// your database calls
		System.out.println("DatabaseAccountDAOImpl:updateAccount");
	}

	public Account loadAccount(String accountNumber) {
		// your database calls
		System.out.println("DatabaseAccountDAOImpl:loadAccount");
		Account a = new Account("");
		a.setCustomer(new Customer(""));
		return a;
	}

	public Collection<Account> getAccounts() {

		// your database calls
		System.out.println("DatabaseAccountDAOImpl:getAccounts");
		return null;
	}

}
