package designPatterns.labs.lab01;

public class CheckingAccountInterestStrategy implements InterestStrategy{
    /**
     * @param acc
     * @return Account
     */
    @Override
    public Account addInterest(Account acc) {
        double balance = acc.getBalance();
        double interest = 0;
        if(balance < 1000){
            interest = 0.015 * balance;
        }else{
            interest = 0.025 * balance;
        }
        acc.deposit(interest,"interest");
        return acc;
    }
}
