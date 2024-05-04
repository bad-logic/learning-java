package designPatterns.labs.lab04;

public abstract class AccountDAOFactory {

    public AccountDAO getAccountDAO(){
        return createAccountDAO();
    }

   abstract AccountDAO createAccountDAO();

}
