package client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import generated.Person;


@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	GreetingClient greetingClient;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Person person = new Person();
		person.setFirstName("Frank");
		person.setLastName("Brown");
		System.out.println(greetingClient.getMessage(person));
	}

}


