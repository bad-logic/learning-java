package designPatterns.labs.lab05;

import java.util.Collection;

public interface AccountService extends Invoker {
    Account createAccount(String accountNumber, String customerName);
    Account getAccount(String accountNumber);
    Collection<Account> getAllAccounts();
}
