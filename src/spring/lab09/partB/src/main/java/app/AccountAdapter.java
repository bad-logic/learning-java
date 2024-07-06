package app;

import app.dto.AccountDTO;
import app.dto.CreateAccountDTO;
import app.dto.CustomerDTO;

public class AccountAdapter {

    public static Account toEntity(CreateAccountDTO acc){
        Account account = new Account();
        account.setBalance(0.0);
        account.setCustomer(new Customer(acc.getName()));
        return account;
    }

    public static AccountDTO toAccountDTO(Account acc){
        Customer customer = acc.getCustomer();
        CustomerDTO cust = new CustomerDTO(customer.getId(),customer.getName());
        return new AccountDTO(acc.getAccountNumber(),cust,acc.getBalance());
    }

}
