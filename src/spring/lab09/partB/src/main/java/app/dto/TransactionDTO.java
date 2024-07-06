package app.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class TransactionDTO {

    @NotNull(message = "account number is mandatory")
    @Positive(message = "account number should be a valid number")
    private Long accountNumber;

    @NotNull(message = "amount is mandatory")
    @Positive(message = "amount must be a positive number")
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
