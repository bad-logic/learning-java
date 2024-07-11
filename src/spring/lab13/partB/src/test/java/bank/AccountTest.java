package bank;

import bank.domain.Account;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class AccountTest {
    private Account account;

    @BeforeEach
    public void init(){
        account = new Account();
    }

    @AfterEach
    public void destroy(){
        account = null;
    }

    @Test
    public void testAmountDeposit(){
        account.deposit(345.99);
        assertThat(account.getBalance(), closeTo(345.99,0.01));
    }

    @Test
    public void testAmountWithdraw(){
        account.withdraw(112.99);
        assertThat(account.getBalance(), closeTo(-112.99,0.01));
    }

    @Test
    public void testTransferFundShouldWithdrawFromOriginAccount(){
        Account destinationAccount = new Account();
        account.transferFunds(destinationAccount,340,"Transferring funds");
        assertThat(account.getBalance(), closeTo(-340,0.01));
    }

    @Test
    public void testTransferFundShouldDepositToDestinationAccount(){
        Account destinationAccount = new Account();
        account.transferFunds(destinationAccount,340,"Transferring funds");
        assertThat(destinationAccount.getBalance(), closeTo(340,0.01));
    }
}
