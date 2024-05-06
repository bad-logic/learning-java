package designPatterns.labs.lab05_alternate.commands;

import designPatterns.labs.lab05_alternate.Account;
import designPatterns.labs.lab05_alternate.AccountEntry;

import java.util.Collection;

public class DepositCommand implements Command {

    /**
     * @param acc
     * @param amount
     */
    @Override
    public void execute(Account acc, double amount, String description) {
        Collection<AccountEntry> entryList = acc.getEntryList();
        AccountEntry entry = new AccountEntry(amount, description, "", "");
        entryList.add(entry);
    }

    /**
     * @param acc
     * @param amount
     */
    @Override
    public void undo(Account acc, double amount, String description) {
        Collection<AccountEntry> entryList = acc.getEntryList();
        AccountEntry entry = new AccountEntry(-amount, "undo:"+description, "", "");
        entryList.add(entry);
    }

    /**
     * @param acc
     * @param amount
     */
    @Override
    public void redo(Account acc, double amount, String description) {
        Collection<AccountEntry> entryList = acc.getEntryList();
        AccountEntry entry = new AccountEntry(amount, "redo:"+description, "", "");
        entryList.add(entry);
    }
}
