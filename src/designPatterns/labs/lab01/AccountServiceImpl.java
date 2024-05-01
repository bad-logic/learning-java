package designPatterns.labs.lab01;

import java.util.Collection;

public class AccountServiceImpl implements AccountService {
    private AccountDAO accountDAO;

    public AccountServiceImpl(){
        accountDAO = new AccountDAOImpl();
    }

    public Account createAccount(String accountNumber, String customerName, AccountType type) {
        Account account = new Account(accountNumber);
        Customer customer = new Customer(customerName);
        account.setCustomer(customer);

        if(type == AccountType.SAVINGS){
            account.setInterestStrategy(new SavingAccountInterestStrategy());
        }else{
            account.setInterestStrategy(new CheckingAccountInterestStrategy());
        }

        accountDAO.saveAccount(account);

        return account;
    }

    public void deposit(String accountNumber, double amount) {
        Account account = accountDAO.loadAccount(accountNumber);
        account.deposit(amount);

        accountDAO.updateAccount(account);
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
    }



    public void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description) {
        Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
        Account toAccount = accountDAO.loadAccount(toAccountNumber);
        fromAccount.transferFunds(toAccount, amount, description);
        accountDAO.updateAccount(fromAccount);
        accountDAO.updateAccount(toAccount);
    }

    /**
     *
     */
    @Override
    public void addInterest() {
        Collection<Account> accountList = accountDAO.getAccounts();
        for(Account acc: accountList){
            acc.addInterest();
        }
    }
}
