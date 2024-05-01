package designPatterns.labs.lab01;

public class SavingAccountInterestStrategy implements InterestStrategy {

    /**
     * @param acc
     * @return Account
     */
    @Override
    public Account addInterest(Account acc) {
       double balance = acc.getBalance();
       double interest = 0;
       if(balance < 1000){
           interest = 0.01 * balance;
       }else if(balance > 5000){
           interest = 0.04 * balance;
       }else{
           interest = 0.02 * balance;
       }
       acc.deposit(interest,"interest");
       return acc;
    }
}
