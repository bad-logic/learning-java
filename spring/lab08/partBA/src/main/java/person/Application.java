package person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		long start = System.currentTimeMillis();
		seedData();
		long finish = System.currentTimeMillis();
		long timeElapsed = finish - start;
		System.out.println("Time Taken to add Person Entries "+timeElapsed+" ms"); // 23227 ms

		long start1 = System.currentTimeMillis();
		retrieveData();
		long finish1 = System.currentTimeMillis();
		long timeElapsed1 = finish1 - start1;
		System.out.println("Time Taken to retrieve Person Entries "+timeElapsed1+" ms"); // 368 ms
	}

	public void seedData(){
		List<Person> lists = new ArrayList<>();
		for(int i=1;i<=10000;i++){
			Person person = new Person("person"+i , i+"last");
			lists.add(person);
			for(int j=1;j<=10;j++) {
				person.addPet(new Pet("Pet" + i + j, j));
			}
		}
		personRepository.saveAll(lists);
	}

	public void retrieveData(){
		personRepository.getAllWithJoinFetch();
	}
}


