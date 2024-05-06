package designPatterns.labs.lab05.commands;

import designPatterns.labs.lab05.Account;

public class TransferFundsCommand implements Command{
    Account toAccount;
    Command deposit;
    Command withdraw;

    public TransferFundsCommand(Account toAccount){
        this.deposit = new DepositCommand();
        this.withdraw = new WithdrawCommand();
        this.toAccount = toAccount;
    }
    /**
     * @param acc
     * @param amount
     */
    @Override
    public void execute(Account acc, double amount, String description) {
        this.deposit.execute(this.toAccount,amount,description);
        this.withdraw.execute(acc,amount,description);
    }

    /**
     * @param acc
     * @param amount
     */
    @Override
    public void undo(Account acc, double amount,String description) {
        this.deposit.execute(acc,amount,"undo:"+description);
        this.withdraw.execute(this.toAccount,amount,"undo:"+description);
    }

    /**
     * @param acc
     * @param amount
     */
    @Override
    public void redo(Account acc, double amount,String description) {
        this.deposit.execute(this.toAccount,amount,"redo:"+description);
        this.withdraw.execute(acc,amount,"redo:"+description);
    }
}
