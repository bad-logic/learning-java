package bank.schedules;

import bank.dtos.AccountDTO;
import bank.dtos.AccountEntryDTO;
import bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class BankStatementPrinter{

    @Autowired
    private AccountService accountService;

    BankStatementPrinter(AccountService accountService){
        this.accountService = accountService;
    }

    @Scheduled(fixedRate = 20, timeUnit = TimeUnit.SECONDS)
    public void execute() {
        System.out.println("Starting to Print the account details");
        List<AccountDTO> accs = this.accountService.getAllAccounts();
        for(AccountDTO a : accs){
            System.out.println("--------------------------------");
            System.out.println("Account number: "+ a.getAccountnumber());
            System.out.println("Account name: " + a.getCustomer().getName());
            System.out.println("Account balance: " + a.getBalance());
            System.out.println("Statements :");
            for(AccountEntryDTO entry: a.getEntryList()){
                System.out.println(entry.getDescription() + ":" + entry.getAmount() + " " + entry.getFromAccountNumber() + " " + entry.getFromPersonName());
            }
        }

        System.out.println("Finished Printing the account details");
    }
}
