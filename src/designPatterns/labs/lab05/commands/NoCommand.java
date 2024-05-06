package designPatterns.labs.lab05.commands;

import designPatterns.labs.lab05.Account;

public class NoCommand implements Command{
    /**
     * @param acc
     * @param amount
     */
    @Override
    public void execute(Account acc, double amount,String description) {

    }

    /**
     * @param acc
     * @param amount
     */
    @Override
    public void undo(Account acc, double amount,String description) {

    }

    /**
     * @param acc
     * @param amount
     */
    @Override
    public void redo(Account acc, double amount,String description) {

    }
}
