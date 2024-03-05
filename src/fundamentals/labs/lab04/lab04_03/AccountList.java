package fundamentals.labs.lab04.lab04_03;

import fundamentals.labs.lab04.lab04_03.employeeinfo.Account;

public class AccountList {

    private Account[] accountsList;
    private int size;

    public AccountList(int... args) {
        int arraySize = args.length == 0 ? 50 : args[0];
        accountsList = new Account[arraySize];
        size = 0;
    }

    private void resize() {
        System.out.println("Resizing...");
        int newLength = accountsList.length * 2;
        Account[] temp = new Account[newLength];
        System.arraycopy(accountsList, 0, temp, 0, accountsList.length);
        accountsList = temp;
    }

    public Account get(int i) {
        if(i<0 || i>= size) return null;
        return this.accountsList[i];
    }

    public void add(Account a) {
        if(size >= this.accountsList.length) {
            resize();
        }
        this.accountsList[size++] = a;
    }

    public Account[] getAccounts(){
        Account[] tempList = new Account[size];
        System.arraycopy(this.accountsList, 0, tempList, 0, size);
        return tempList;
    }

    public int size() {
        return this.size;
    }
}
