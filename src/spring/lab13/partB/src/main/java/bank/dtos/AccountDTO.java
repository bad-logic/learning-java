package bank.dtos;

import java.util.ArrayList;
import java.util.Collection;

public class AccountDTO {

    private long accountnumber;

    private double balance;

    Collection<AccountEntryDTO> entryList = new ArrayList<AccountEntryDTO>();

    CustomerDTO customer;

    public AccountDTO(long accountnumber, Collection<AccountEntryDTO> entryList, CustomerDTO customer, double balance) {
        this.accountnumber = accountnumber;
        this.entryList = entryList;
        this.customer = customer;
        this.balance = balance;
    }

    public long getAccountnumber() {
        return accountnumber;
    }

    public Collection<AccountEntryDTO> getEntryList() {
        return entryList;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "AccountDTO{" +
                "accountnumber=" + accountnumber +
                ", balance=" + balance +
                ", entryList=" + entryList +
                ", customer=" + customer +
                '}';
    }
}
