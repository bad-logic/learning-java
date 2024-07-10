package bank.events;

import bank.dtos.TransactionDTO;
import bank.dtos.TransferDTO;

public class AccountChangeEvent {
    private final AccountEvents event;
    private final TransactionDTO transaction;
    private final TransferDTO transfer;

    public AccountChangeEvent(AccountEvents event, TransactionDTO transaction) {
        this.event = event;
        this.transaction = transaction;
        this.transfer = null;
    }
    public AccountChangeEvent(AccountEvents event, TransferDTO transfer) {
        this.event = event;
        this.transaction = null;
        this.transfer = transfer;
    }

    public AccountEvents getEvent() {
        return event;
    }

    public TransactionDTO getTransaction() {
        return transaction;
    }

    public TransferDTO getTransfer() {
        return transfer;
    }
}
