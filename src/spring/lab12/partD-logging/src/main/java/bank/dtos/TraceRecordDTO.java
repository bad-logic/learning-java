package bank.dtos;

import bank.events.AccountEvents;

import java.time.LocalDate;

public class TraceRecordDTO {
    private long id;
    private LocalDate date;
    private Long accountNumber;
    private AccountEvents event;
    private double amount;

    private long fromAccountNumber;

    public TraceRecordDTO(long accountNumber, double amount, LocalDate date, AccountEvents event, long id) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.date = date;
        this.event = event;
        this.id = id;
    }

    public TraceRecordDTO(long accountNumber, double amount, LocalDate date, AccountEvents event, long fromAccountNumber, long id) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.date = date;
        this.event = event;
        this.fromAccountNumber = fromAccountNumber;
        this.id = id;
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

    public long getFromAccountNumber() {
        return fromAccountNumber;
    }

    public void setFromAccountNumber(long fromAccountNumber) {
        this.fromAccountNumber = fromAccountNumber;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TraceRecordDTO{" +
                "accountNumber=" + accountNumber +
                ", id=" + id +
                ", date=" + date +
                ", event=" + event +
                ", amount=" + amount +
                '}';
    }
}
