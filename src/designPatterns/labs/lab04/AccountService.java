package designPatterns.labs.lab04;

import java.util.Collection;

public interface AccountService {
    Account createAccount(String accountNumber, String customerName);
    Account getAccount(String accountNumber);
    void setAccountDAO(AccountDAOFactory accountFactory);
    Collection<Account> getAllAccounts();
    void deposit (String accountNumber, double amount);
    void withdraw (String accountNumber, double amount);
    void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description);
}
