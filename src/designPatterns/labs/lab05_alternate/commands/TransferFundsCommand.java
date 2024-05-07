package designPatterns.labs.lab05_alternate.commands;

import designPatterns.labs.lab05_alternate.Account;

public class TransferFundsCommand implements Command {
    private final Account toAccount;
    private final Account fromAccount;
    private final double amount;
    private final String description;

    public TransferFundsCommand(Account fromAccount, Account toAccount, double amount, String description){
        this.fromAccount = fromAccount;
        this.amount = amount;
        this.description = description;
        this.toAccount = toAccount;
    }


    public void execute()  {
        new DepositCommand(this.toAccount,this.amount,this.description).execute();
        new WithdrawCommand(this.fromAccount,this.amount,this.description).execute();
    }

    public void redo() {
        new DepositCommand(this.toAccount,this.amount,"redo:"+this.description).execute();
        new WithdrawCommand(this.fromAccount,this.amount,"redo:"+this.description).execute();
    }

    public void undo() {
        new DepositCommand(this.fromAccount,this.amount,"undo:"+this.description).execute();
        new WithdrawCommand(this.toAccount,this.amount,"undo:"+this.description).execute();
    }
}
