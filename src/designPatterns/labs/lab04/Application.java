package designPatterns.labs.lab04;

public class Application {
	public static void main(String[] args) {

		AccountDAOFactory accountFactory1 = new MockAccountDAOFactory();
		AccountDAOFactory accountFactory2 = new DatabaseAccountDAOFactory();

		// decide at runtime whether you want the real database implementation or mock implementation

		// here we are using mock implementation
		AccountService accountService = new AccountServiceImpl(accountFactory1);
		// if you want to switch the accountDAO use the setter method in account service

		// account 1
		accountService.createAccount("1263862", "Frank Brown");
		accountService.deposit("1263862", 240);
		accountService.deposit("1263862", 529);
		accountService.withdraw("1263862", 230);

		// let's use database dao for another Account
		// Account 2;
		accountService.setAccountDAO(accountFactory2);
		accountService.createAccount("4253892", "John Doe");
		accountService.deposit("4253892", 12450);
		accountService.transferFunds("4253892", "1263862", 100, "payment of invoice 10232");
	}

}
