package bank.adapter;

import bank.domain.Account;
import bank.domain.Customer;
import bank.dtos.AccountDto;
import bank.dtos.AccountEntryDto;
import bank.dtos.CustomerDto;
import java.util.List;

public class AccountAdapter {

    public static Account toAccountDomain(AccountDto data){
        Account domain = new Account();
        domain.setAccountnumber(data.getAccountnumber());
        domain.setCustomer(new Customer(data.getCustomer().getName()));
        return domain;
    }

    public static AccountDto toAccountDto(Account data){
        List<AccountEntryDto> entries = data.getEntryList().stream().map(l-> new AccountEntryDto(l.getId(),l.getDate(),l.getAmount(),l.getDescription(),l.getFromAccountNumber(),l.getFromPersonName())).toList();
        CustomerDto customer = new CustomerDto(data.getCustomer().getId(),data.getCustomer().getName());
        return new AccountDto(data.getId(),data.getAccountnumber(),entries,customer,data.getBalance());
    }
}
