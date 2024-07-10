package bank;
import bank.dtos.CreateAccountDTO;
import bank.dtos.TransactionDTO;
import bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableScheduling
public class Application implements CommandLineRunner {

	private final RestTemplate restTemplate = new RestTemplate();

	@Autowired
	AccountService accountService;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String serverUrl = "http://localhost:8080/accounts";
		restTemplate.postForLocation(serverUrl, new CreateAccountDTO("Frank"));
		restTemplate.postForLocation(serverUrl, new CreateAccountDTO("John"));
		restTemplate.postForLocation(serverUrl+"/deposit", new TransactionDTO(1L,345.99));
		restTemplate.postForLocation(serverUrl+"/deposit", new TransactionDTO(2L,300));
		restTemplate.postForLocation(serverUrl+"/withdraw", new TransactionDTO(1L,200));
	}

}


