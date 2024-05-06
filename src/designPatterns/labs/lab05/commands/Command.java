package designPatterns.labs.lab05.commands;

import designPatterns.labs.lab05.Account;

public interface Command {
    abstract void execute(Account acc,double amount,String description);
    abstract void undo(Account acc,double amount,String description);
    abstract void redo(Account acc,double amount,String description);
}
