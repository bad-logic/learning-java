package kafka.dtos;

public class TransactionDTO {
    private Long accountNumber;

    private double amount;

    public TransactionDTO(Long accountNumber, double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "TransactionDTO{" +
                "accountNumber=" + accountNumber +
                ", amount=" + amount +
                '}';
    }
}
