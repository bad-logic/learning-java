package designPatterns.labs.lab04;

import java.util.ArrayList;
import java.util.Collection;

public class MockAccountDAOImpl implements AccountDAO {
	Collection<Account> accountlist = new ArrayList<Account>();

	public void saveAccount(Account account) {
		accountlist.add(account); // add the new
		System.out.println("MockAccountDAOImpl:saveAccount");
	}

	public void updateAccount(Account account) {
		Account accountexist = loadAccount(account.getAccountNumber());
		if (accountexist != null) {
			accountlist.remove(accountexist); // remove the old
			accountlist.add(account); // add the new
		}
		System.out.println("MockAccountDAOImpl:updateAccount");

	}

	public Account loadAccount(String accountNumber) {
		for (Account account : accountlist) {
			if (account.getAccountNumber() == accountNumber) {
				return account;
			}
		}
		System.out.println("MockAccountDAOImpl:loadAccount");
		return null;
	}

	public Collection<Account> getAccounts() {
		System.out.println("MockAccountDAOImpl:getAccounts");
		return accountlist;
	}

}
