package bank.dtos;

import bank.events.AccountEvents;

import java.time.LocalDate;

public class CreateTraceRecordDTO {
    private LocalDate date;

    private long accountNumber;

    private AccountEvents event;

    private double amount;

    private long fromAccountNumber;

    public CreateTraceRecordDTO() {
    }

    public CreateTraceRecordDTO(long accountNumber, double amount, LocalDate date, AccountEvents event) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.date = date;
        this.event = event;
    }

    public CreateTraceRecordDTO(long accountNumber, double amount, LocalDate date, AccountEvents event, long fromAccountNumber) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.date = date;
        this.event = event;
        this.fromAccountNumber = fromAccountNumber;
    }

    public long getFromAccountNumber() {
        return fromAccountNumber;
    }

    public void setFromAccountNumber(long fromAccountNumber) {
        this.fromAccountNumber = fromAccountNumber;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public AccountEvents getEvent() {
        return event;
    }

    public void setEvent(AccountEvents event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "CreateTraceRecordDTO{" +
                "accountNumber=" + accountNumber +
                ", date=" + date +
                ", event=" + event +
                ", amount=" + amount +
                '}';
    }
}
