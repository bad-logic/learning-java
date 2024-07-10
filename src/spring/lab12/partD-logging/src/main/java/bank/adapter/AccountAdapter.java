package bank.adapter;

import bank.domain.Account;
import bank.domain.Customer;
import bank.dtos.AccountDTO;
import bank.dtos.AccountEntryDTO;
import bank.dtos.CreateAccountDTO;
import bank.dtos.CustomerDTO;
import java.util.List;

public class AccountAdapter {

    public static Account toAccountDomain(CreateAccountDTO data){
        Account domain = new Account();
        domain.setCustomer(new Customer(data.getName()));
        return domain;
    }

    public static AccountDTO toAccountDto(Account data){
        List<AccountEntryDTO> entries = data.getEntryList().stream().map(l-> new AccountEntryDTO(l.getId(),l.getDate(),l.getAmount(),l.getDescription(),l.getFromAccountNumber())).toList();
        CustomerDTO customer = new CustomerDTO(data.getCustomer().getId(),data.getCustomer().getName());
        return new AccountDTO(data.getAccountnumber(),entries,customer,data.getBalance());
    }
}
