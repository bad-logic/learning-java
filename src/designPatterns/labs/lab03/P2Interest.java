package designPatterns.labs.lab03;

public class P2Interest extends InterestPromotionDecorator{

    P2Interest(InterestStrategy interestStrategy){
        this.interesetStrategy = interestStrategy;
    }

    /**
     * @param acc
     * @return
     */
    @Override
    public Account addInterest(Account acc) {
        // add interest based on checking or saving accounts
        this.interesetStrategy.addInterest(acc);

        // add p2 promotional interest
        double balance = acc.getBalance();
        double interest = 0.02 * balance;
        acc.deposit(interest,"p2 Interest");
        return acc;
    }
}
