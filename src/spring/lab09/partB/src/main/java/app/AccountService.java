package app;

import app.dto.AccountDTO;
import app.dto.CreateAccountDTO;
import app.dto.TransactionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public AccountService( AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    public List<AccountDTO> getAccounts(){
        return this.accountRepository.findAll().stream().map(AccountAdapter::toAccountDTO).toList();
    }

    public AccountDTO createAccount(CreateAccountDTO data){
        Account entity = AccountAdapter.toEntity(data);
        this.accountRepository.save(entity);
        return AccountAdapter.toAccountDTO(entity);
    }

    public AccountDTO deposit(TransactionDTO data) throws RestException {
        Optional<Account> acc = this.accountRepository.findById(data.getAccountNumber());
        if(acc.isEmpty()) throw new RestException("account does not exist", HttpStatus.NOT_FOUND);
        Account a = acc.get();
        a.setBalance(a.getBalance() + data.getAmount());
        this.accountRepository.save(a);
        return AccountAdapter.toAccountDTO(a);
    }

    public AccountDTO withdraw(TransactionDTO data) throws RestException {
        Optional<Account> acc = this.accountRepository.findById(data.getAccountNumber());
        if(acc.isEmpty()) throw new RestException("account does not exist", HttpStatus.NOT_FOUND);
        Account a = acc.get();
        if(a.getBalance() < data.getAmount() ) throw new RestException("Not sufficient balance", HttpStatus.BAD_REQUEST);
        a.setBalance(a.getBalance() - data.getAmount());
        this.accountRepository.save(a);
        return AccountAdapter.toAccountDTO(a);
    }
}
