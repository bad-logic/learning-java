package app;



import app.dto.AccountDTO;
import app.dto.CreateAccountDTO;
import app.dto.TransactionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import java.util.List;


@SpringBootApplication
public class Application implements CommandLineRunner{
	private RestTemplate restTemplate = new RestTemplate();


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

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
		restTemplate.postForLocation(serverUrl+"/deposit", new TransactionDTO(1L,345.99));
		restTemplate.postForLocation(serverUrl+"/deposit", new TransactionDTO(2L,300));
		accounts = restTemplate.exchange(
				serverUrl,
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<AccountDTO>>() {}
		).getBody();
		System.out.println(accounts);

		System.out.println("----------------- withdraw accounts ------------------");
		restTemplate.postForLocation(serverUrl+"/withdraw", new TransactionDTO(1L,200));

		accounts = restTemplate.exchange(
				serverUrl,
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<AccountDTO>>() {}
		).getBody();
		System.out.println(accounts);
	}

}
