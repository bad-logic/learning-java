package client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	CalculatorClient calculatorClient;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("1 + 3 = " + calculatorClient.add(1,3));
		System.out.println("1 - 3 = " + calculatorClient.subtract(1,3));
		System.out.println("5 * 3 = " + calculatorClient.multiply(5,3));
	}

}


