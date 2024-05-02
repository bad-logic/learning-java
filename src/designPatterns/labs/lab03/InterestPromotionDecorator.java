package designPatterns.labs.lab03;

public abstract class InterestPromotionDecorator implements InterestStrategy{

    InterestStrategy interesetStrategy;

    abstract public Account addInterest(Account acc);
}
