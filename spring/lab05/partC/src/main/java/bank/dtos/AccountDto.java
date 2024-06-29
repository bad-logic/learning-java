package bank.dtos;

import java.util.ArrayList;
import java.util.Collection;

public class AccountDto {

    private int id;

    private long accountnumber;

    private double balance;

    Collection<AccountEntryDto> entryList = new ArrayList<AccountEntryDto>();

    CustomerDto customer;

    public AccountDto(int id, long accountnumber, Collection<AccountEntryDto> entryList, CustomerDto customer,double balance) {
        this.id = id;
        this.accountnumber = accountnumber;
        this.entryList = entryList;
        this.customer = customer;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public long getAccountnumber() {
        return accountnumber;
    }

    public Collection<AccountEntryDto> getEntryList() {
        return entryList;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public double getBalance() {
        return balance;
    }
}
