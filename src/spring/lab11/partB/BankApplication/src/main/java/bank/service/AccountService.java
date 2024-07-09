package bank.service;

import java.util.List;
import java.util.Optional;

import bank.adapter.AccountAdapter;
import bank.common.RestException;
import bank.domain.Account;
import bank.dtos.AccountDTO;
import bank.dtos.CreateAccountDTO;
import bank.dtos.TransactionDTO;
import bank.dtos.TransferDTO;
import bank.jms.IJMSSender;
import bank.logging.ILogger;
import bank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;



@Service
public class AccountService implements IAccountService {

	@Autowired
	private ICurrencyConverter currencyConverter;
	@Autowired
	private IJMSSender jmsSender;
	@Autowired
	private ILogger logger;
	@Autowired
	private AccountRepository accountRepository;
	
	public AccountService(AccountRepository accountRepository,ICurrencyConverter currencyConverter,IJMSSender jmsSender,ILogger logger){
		this.accountRepository = accountRepository;
		this.currencyConverter = currencyConverter;
		this.jmsSender = jmsSender;
		this.logger = logger;
	}

	public AccountDTO getAccount(long accountNumber) throws RestException {
		Optional<Account> account =this.accountRepository.findById(accountNumber);
		if(account.isEmpty()) throw new RestException("account does not exist", HttpStatus.NOT_FOUND);
		return AccountAdapter.toAccountDto(account.get());
	}

	public List<AccountDTO> getAllAccounts() {
		return this.accountRepository.findAll().stream().map(AccountAdapter::toAccountDto).toList();
	}

	public AccountDTO createAccount(CreateAccountDTO data){
		Account entity = AccountAdapter.toAccountDomain(data);
		this.accountRepository.save(entity);
		logger.log("createAccount with parameters accountNumber= "+entity.getAccountnumber()+" , customerName= "+entity.getCustomer().getName());
		return AccountAdapter.toAccountDto(entity);
	}

	public void deposit(TransactionDTO data) throws RestException {
		Optional<Account> acc = this.accountRepository.findById(data.getAccountNumber());
		if(acc.isEmpty()) throw new RestException("account does not exist", HttpStatus.NOT_FOUND);
		Account a = acc.get();
		a.deposit(data.getAmount());
		this.accountRepository.save(a);

		logger.log("deposit with parameters accountNumber= "+data.getAccountNumber()+" , amount= "+data.getAmount());
		if (data.getAmount() > 10000){
			jmsSender.sendJMSMessage("Deposit of $ "+data.getAmount()+" to account with accountNumber= "+data.getAccountNumber());
		}
	}

	public void withdraw(TransactionDTO data) throws RestException {
		Optional<Account> acc = this.accountRepository.findById(data.getAccountNumber());
		if(acc.isEmpty()) throw new RestException("account does not exist", HttpStatus.NOT_FOUND);
		Account a = acc.get();
		a.withdraw(data.getAmount());
		this.accountRepository.save(a);
		logger.log("withdraw with parameters accountNumber= "+data.getAccountNumber()+" , amount= "+data.getAmount());
	}

	public void depositEuros(TransactionDTO data) throws RestException {
		Optional<Account> acc = this.accountRepository.findById(data.getAccountNumber());
		if(acc.isEmpty()) throw new RestException("account does not exist", HttpStatus.NOT_FOUND);
		Account a = acc.get();
		double amountDollars = currencyConverter.euroToDollars(data.getAmount());
		a.deposit(amountDollars);
		this.accountRepository.save(a);
		logger.log("depositEuros with parameters accountNumber= "+data.getAccountNumber()+" , amount= "+data.getAmount());
		if (amountDollars > 10000){
			jmsSender.sendJMSMessage("Deposit of $ "+amountDollars+" to account with accountNumber= "+data.getAccountNumber());
		}
	}

	public void withdrawEuros(TransactionDTO data) throws RestException {
		Optional<Account> acc = this.accountRepository.findById(data.getAccountNumber());
		if(acc.isEmpty()) throw new RestException("account does not exist", HttpStatus.NOT_FOUND);
		Account a = acc.get();
		double amountDollars = currencyConverter.euroToDollars(data.getAmount());
		a.withdraw(amountDollars);
		this.accountRepository.save(a);
		logger.log("withdrawEuros with parameters accountNumber= "+data.getAccountNumber()+" , amount= "+data.getAmount());
	}

	public void transferFunds(TransferDTO data) throws RestException {
		Optional<Account> fromAccount = this.accountRepository.findById(data.getFromAccountNumber());
		Optional<Account> toAccount = this.accountRepository.findById(data.getToAccountNumber());
		if(fromAccount.isEmpty() || toAccount.isEmpty()) throw new RestException("account does not exist", HttpStatus.NOT_FOUND);
		Account fAcc = fromAccount.get();
		Account tAcc = toAccount.get();
		fAcc.transferFunds(tAcc, data.getAmount(), data.getDescription());
		this.accountRepository.saveAll(List.of(fAcc,tAcc));

		logger.log("transferFunds with parameters fromAccountNumber= "+fAcc.getAccountnumber()+" , toAccountNumber= "+tAcc.getAccountnumber()+" , amount= "+data.getAmount()+" , description= "+data.getDescription());
		if (data.getAmount() > 10000){
			jmsSender.sendJMSMessage("TransferFunds of $ "+data.getAmount()+" from account with accountNumber= "+data.getFromAccountNumber()+" to account with accountNumber= "+data.getToAccountNumber());
		}
	}
}
