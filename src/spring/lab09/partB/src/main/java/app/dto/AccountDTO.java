package app.dto;


public class AccountDTO {

    private Long accountNumber;
    private CustomerDTO customer;
    private double balance;

    public AccountDTO() {
    }

    public AccountDTO(long accountNumber, CustomerDTO customer, double balance) {
        this.accountNumber = accountNumber;
        this.customer = customer;
        this.balance = balance;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "AccountDTO{" +
                "accountNumber=" + accountNumber +
                ", customer=" + customer +
                ", balance=" + balance +
                '}';
    }
}
