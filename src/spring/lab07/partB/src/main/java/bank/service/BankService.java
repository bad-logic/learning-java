package bank.service;
import bank.integration.EmailSender;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bank.domain.Account;
import bank.domain.Customer;
import bank.repositories.AccountRepository;
import bank.repositories.CustomerRepository;

@Service
public class BankService {
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private EmailSender emailSender;
	

	@Transactional()
	public void createCustomerAndAccount(int customerId, String customerName, String emailAddress, String accountNumber){
		try{

			Account account = new Account(accountNumber);
			accountRepository.save(account);
			Customer customer = new Customer(customerId, customerName);
			customer.setAccount(account);
			customerRepository.saveCustomer(customer);
			emailSender.sendEmail(emailAddress, "Welcome "+customerName);
		}catch (Exception ex){
			emailSender.sendEmail(emailAddress, "We could not create your account "+accountNumber);
			throw ex;
		}
	}

}
