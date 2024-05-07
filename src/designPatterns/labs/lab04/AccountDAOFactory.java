package designPatterns.labs.lab04;

public abstract class AccountDAOFactory {

    public AccountDAO getAccountDAO(){
        return createAccountDAO();
    }

    // we can only have this method here since we are not doing anything with the object in getAccountDAO
   abstract AccountDAO createAccountDAO();

}
