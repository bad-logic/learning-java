package accounts.repository;

import accounts.domain.Account;
import accounts.repositories.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void findByAccountHolderShouldReturnTheAccountWithTheGivenAccountHolder(){
        Account acc = new Account("1234",234.56,"Ben");
        entityManager.persist(acc);
        entityManager.flush();

        Account account = accountRepository.findByAccountHolder("Ben");
        assertThat(acc.getAccountHolder(),equalTo(account.getAccountHolder()));
    }
}
