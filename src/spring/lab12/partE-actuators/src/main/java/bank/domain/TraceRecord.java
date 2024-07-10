package bank.domain;

import bank.events.AccountEvents;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class TraceRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate date;

    private Long accountNumber;

    @Enumerated(value = EnumType.STRING)
    private AccountEvents event;

    private double amount;

    private Long fromAccountNumber;

    public TraceRecord() {}

    public TraceRecord( AccountEvents event, LocalDate date, double amount, long accountNumber) {
        this.event = event;
        this.date = date;
        this.amount = amount;
        this.accountNumber = accountNumber;
    }

    public TraceRecord( AccountEvents event, LocalDate date, double amount, long accountNumber, long fromAccountNumber) {
        this.event = event;
        this.date = date;
        this.amount = amount;
        this.accountNumber = accountNumber;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TraceRecord{" +
                "accountNumber=" + accountNumber +
                ", id=" + id +
                ", date=" + date +
                ", event=" + event +
                ", amount=" + amount +
                '}';
    }
}
