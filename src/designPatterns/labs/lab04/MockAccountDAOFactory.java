package designPatterns.labs.lab04;

public class MockAccountDAOFactory extends AccountDAOFactory{
    /**
     * @return
     */
    @Override
    AccountDAO createAccountDAO() {
        return new MockAccountDAOImpl();
    }
}
