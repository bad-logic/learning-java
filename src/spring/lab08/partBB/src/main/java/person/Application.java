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

//	@Autowired
//	PetRepository petRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		long start = System.currentTimeMillis();
		seedData();
		long finish = System.currentTimeMillis();
		long timeElapsed = finish - start;
		System.out.println("Time Taken to add Person Entries "+timeElapsed+" ms"); // embedded = 680 ms, seperate document = 16649 ms

		long start1 = System.currentTimeMillis();
		retrieveData();
		long finish1 = System.currentTimeMillis();
		long timeElapsed1 = finish1 - start1;
		System.out.println("Time Taken to retrieve Person Entries "+timeElapsed1+" ms"); // embedded = 406 ms, seperate document = 2789 ms
	}

	public void seedData(){
		List<Person> lists = new ArrayList<>();
		for(int i=1;i<=10000;i++){
			Person person = new Person("person"+i , i+"last");
			lists.add(person);
			for(int j=1;j<=10;j++) {
//				Pet pet = petRepository.save(new Pet("Pet" + i + j, j));
				Pet pet = new Pet("Pet" + i + j, j);
				person.addPet(pet);
			}
		}
		personRepository.saveAll(lists);
	}

	public void retrieveData(){
//		personRepository.getAllPersonsWithPets();
		personRepository.findAll();
	}
}


