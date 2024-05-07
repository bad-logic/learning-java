package designPatterns.labs.lab05;

import designPatterns.labs.lab05.commands.Command;
import designPatterns.labs.lab05.commands.DepositCommand;
import designPatterns.labs.lab05.commands.TransferFundsCommand;
import designPatterns.labs.lab05.commands.WithdrawCommand;

public class Application {
	public static void main(String[] args) {
		AccountService accountService = new AccountServiceImpl();

		// create 2 accounts;
		Account acc1 = accountService.createAccount("1263862", "Frank Brown");
		Account acc2 = accountService.createAccount("4253892", "John Doe");

		// use account 1;
		accountService.setCommand(new DepositCommand(acc1,240,"Deposit"));
		accountService.execute();

		accountService.setCommand(new DepositCommand(acc1,529,"Deposit"));
		accountService.execute();

		accountService.redo();
		accountService.undo();

		accountService.setCommand(new WithdrawCommand(acc1,230,"Withdraw"));
		accountService.execute();

		// use account 2;
		accountService.setCommand(new DepositCommand(acc2,12450,"Deposit"));
		accountService.execute();

		Command transfer = new TransferFundsCommand(acc2, acc1,100,"payment of invoice 10232");
		accountService.setCommand(transfer);
		accountService.execute();

		accountService.redo();
		accountService.undo();

		// show balances
		for (Account account : accountService.getAllAccounts()) {
			Customer customer = account.getCustomer();
			System.out.println("Statement for Account: " + account.getAccountNumber());
			System.out.println("Account Holder: " + customer.getName());
			
			System.out.println("-Date-------------------------" 
					+ "-Description------------------" 
					+ "-Amount-------------");
			
			for (AccountEntry entry : account.getEntryList()) {
				System.out.printf("%30s%30s%20.2f\n", 
						entry.getDate().toString(), 
						entry.getDescription(),
						entry.getAmount());
			}
			
			System.out.println("----------------------------------------" + "----------------------------------------");
			System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:", account.getBalance());
		}
	}

}
