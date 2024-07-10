package bank.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class TransferDTO {

    @NotNull(message = "account number is mandatory")
    @Positive(message = "account number should be a valid number")
    private Long fromAccountNumber;

    @NotNull(message = "account number is mandatory")
    @Positive(message = "account number should be a valid number")
    private Long toAccountNumber;

    @NotNull(message = "amount is mandatory")
    @Positive(message = "amount must be a positive number")
    private double amount;

    @NotNull(message = "description is mandatory")
    @Size(min = 2, max = 10, message = "name must be between 2 and 50 characters")
    private String description;

    public TransferDTO(double amount, Long fromAccountNumber, Long toAccountNumber) {
        this.amount = amount;
        this.fromAccountNumber = fromAccountNumber;
        this.toAccountNumber = toAccountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Long getFromAccountNumber() {
        return fromAccountNumber;
    }

    public void setFromAccountNumber(Long fromAccountNumber) {
        this.fromAccountNumber = fromAccountNumber;
    }

    public Long getToAccountNumber() {
        return toAccountNumber;
    }

    public void setToAccountNumber(Long toAccountNumber) {
        this.toAccountNumber = toAccountNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "TransferDTO{" +
                "amount=" + amount +
                ", fromAccountNumber=" + fromAccountNumber +
                ", toAccountNumber=" + toAccountNumber +
                '}';
    }
}
