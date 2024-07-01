package bank.dtos;

import java.time.LocalDateTime;

public class AccountEntryDto {

    private long id;

    private LocalDateTime date;
    private double amount;
    private String description;
    private String fromAccountNumber;
    private String fromPersonName;

    public AccountEntryDto(long id, LocalDateTime date, double amount, String description, String fromAccountNumber, String fromPersonName) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.description = description;
        this.fromAccountNumber = fromAccountNumber;
        this.fromPersonName = fromPersonName;
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public String getFromAccountNumber() {
        return fromAccountNumber;
    }

    public String getFromPersonName() {
        return fromPersonName;
    }
}
