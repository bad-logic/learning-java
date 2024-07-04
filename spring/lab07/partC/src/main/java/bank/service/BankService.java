package bank.service;
import bank.domain.Tracerecord;
import bank.integration.EmailSender;
import bank.repositories.TracerecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bank.domain.Account;
import bank.domain.Customer;
import bank.repositories.AccountRepository;
import bank.repositories.CustomerRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class BankService {
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private EmailSender emailSender;
	@Autowired
	private TracerecordRepository tracerecordRepository;

	@Transactional()
	public void createCustomerAndAccount(int customerId, String customerName, String emailAddress, String accountNumber){
		try{
			Account account = new Account(accountNumber);
			accountRepository.save(account);
			Customer customer = new Customer(customerId, customerName);
			customer.setAccount(account);
			customerRepository.saveCustomer(customer);
			emailSender.sendEmail(emailAddress, "Welcome "+customerName);
			tracerecordRepository.addRecord(new Tracerecord(LocalDateTime.now(),"Customer "+customerName+" created with account " + accountNumber));
		}catch (Exception ex){
			emailSender.sendEmail(emailAddress, "We could not create your account "+accountNumber);
			tracerecordRepository.addRecord(new Tracerecord(LocalDateTime.now(),"Could not create customer "+customerName+" with account " + accountNumber));
			throw ex;
		}
	}

}
