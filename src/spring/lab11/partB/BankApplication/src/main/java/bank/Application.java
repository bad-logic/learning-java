package bank;

import java.util.List;
import bank.dtos.AccountDTO;
import bank.dtos.CreateAccountDTO;
import bank.dtos.TransactionDTO;
import bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableJms
public class Application implements CommandLineRunner {

	@Autowired
	AccountService accountService;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		try{

		 	RestTemplate restTemplate = new RestTemplate();

			String serverUrl = "http://localhost:8080/accounts";

			System.out.println("----------------- adding accounts ------------------");
			restTemplate.postForLocation(serverUrl, new CreateAccountDTO("Frank"));
			restTemplate.postForLocation(serverUrl, new CreateAccountDTO("John"));

			List<AccountDTO> accounts = restTemplate.exchange(
					serverUrl,
					HttpMethod.GET,
					null,
					new ParameterizedTypeReference<List<AccountDTO>>() {}
			).getBody();
			System.out.println(accounts);

			System.out.println("----------------- deposit accounts ------------------");
			restTemplate.postForLocation(serverUrl+"/deposit", new TransactionDTO(1L,11000));
			restTemplate.postForLocation(serverUrl+"/deposit", new TransactionDTO(2L,12345));
			accounts = restTemplate.exchange(
					serverUrl,
					HttpMethod.GET,
					null,
					new ParameterizedTypeReference<List<AccountDTO>>() {}
			).getBody();
			System.out.println(accounts);

			System.out.println("----------------- withdraw accounts ------------------");
			restTemplate.postForLocation(serverUrl+"/withdraw", new TransactionDTO(1L,1200));

			accounts = restTemplate.exchange(
					serverUrl,
					HttpMethod.GET,
					null,
					new ParameterizedTypeReference<List<AccountDTO>>() {}
			).getBody();
			System.out.println(accounts);
		}catch (Exception ex){
			System.out.println("ex: "+ ex.getMessage());
		}
	}
}


