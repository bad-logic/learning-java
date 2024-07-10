package bank;
import bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class Application {

	@Autowired
	AccountService accountService;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}


