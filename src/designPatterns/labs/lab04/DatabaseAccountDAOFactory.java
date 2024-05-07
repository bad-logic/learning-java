package designPatterns.labs.lab04;

public class DatabaseAccountDAOFactory extends AccountDAOFactory{
    /**
     * @return
     */
    @Override
    AccountDAO createAccountDAO() {
        return new DatabaseAccountDAOImpl();
    }
}
