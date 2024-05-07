package designPatterns.labs.lab03;

public class P1Interest extends InterestPromotionDecorator{

    P1Interest(InterestStrategy interestStrategy){
        this.interestStrategy = interestStrategy;
    }

    /**
     * @param acc
     * @return
     */
    @Override
    public Account addInterest(Account acc) {
        // add interest based on checking or saving accounts
        this.interestStrategy.addInterest(acc);

        // add p1 promotional interest
        double balance = acc.getBalance();
        double interest = 0.01 * balance;
        acc.deposit(interest,"p1 Interest");
        return acc;
    }
}
