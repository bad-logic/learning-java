package designPatterns.labs.lab05.commands;

import designPatterns.labs.lab05.Account;

public class WithdrawCommand implements Command{

    private final Account acc;
    private final double amount;
    private final String description;

    public WithdrawCommand(Account acc,double amount,String description){
        this.acc = acc;
        this.amount = amount;
        this.description = description;
    }

    @Override
    public void execute() {
        this.acc.withdraw(this.amount,this.description);
    }

    public void redo() {
        this.acc.withdraw(this.amount,"redo:"+this.description);
    }

    public void undo() {
        this.acc.deposit(this.amount,"undo:"+this.description);
    }

}
