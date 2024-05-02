package designPatterns.labs.lab03;

public abstract class InterestPromotionDecorator implements InterestStrategy{

    InterestStrategy interestStrategy;

    abstract public Account addInterest(Account acc);
}
