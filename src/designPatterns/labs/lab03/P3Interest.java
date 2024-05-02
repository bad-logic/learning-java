package designPatterns.labs.lab03;

public class P3Interest extends InterestPromotionDecorator{

    P3Interest(InterestStrategy interestStrategy){
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

        // add p3 promotional interest
        double balance = acc.getBalance();
        double interest = 0.03 * balance;
        acc.deposit(interest,"p3 Interest");
        return acc;
    }
}
