package app;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
public class Application implements CommandLineRunner{
	
	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	SchoolRepository schoolRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		insertCustomers();
		retrieveCustomers();
		updateCustomers();
		insertSchoolAndStudents();
		fetchSchoolsWithoutStudents();
		fetchSchoolsWithStudents();
	}

	private void insertSchoolAndStudents(){
		for(int i=0;i<1000;i++){
			School school = new School("school"+i);
			for(int j=0;j<500;j++){
				System.out.println("Inserting student  "+j);
				Student s = new Student("x"+i+"ford"+j,"xl"+j+"ast"+i,"x"+i+"ford"+j+"xl"+j+"ast"+i+"@school"+i+".edu");
				school.addStudent(s);
			}
			System.out.println("Inserting school  "+i);
			schoolRepository.save(school);
		}
	}
//13339 //58
	private void fetchSchoolsWithoutStudents(){
		System.out.println("Retrieving all schools without students ...");
		long start = System.currentTimeMillis();
		List<School> schools = schoolRepository.findAll();
		System.out.println("schools fetched" + schools.size());
		for(School school: schools){
			System.out.println(school.getName());
		}
		long finish = System.currentTimeMillis();
		long timeElapsed = finish - start;
		System.out.println("To retrieve all schools without students took "+timeElapsed+" ms");
	}

//	13339 with eager students // 2409 with join fetch
	private void fetchSchoolsWithStudents(){
		System.out.println("Retrieving all schools with students ...");
		long start = System.currentTimeMillis();
		List<School> schools = schoolRepository.findAllWithStudents();
		for(School school: schools){
			System.out.println(school.getName());
			for(Student s:school.getStudents()){
				System.out.println(s.getFirstname()+s.getLastname());
			}
		}
		long finish = System.currentTimeMillis();
		long timeElapsed = finish - start;
		System.out.println("To retrieve all schools with students took "+timeElapsed+" ms");
	}

	private void insertCustomers() {
		for (int x=0; x<50000; x++) {
			Customer customer = new Customer("John Doe "+x);
			Account account = new Account("123"+x);
			customer.setAccount(account);
			customerRepository.save(customer);
			System.out.println("Inserting customer  "+x);
		}
	}

	private void retrieveCustomers() {
		System.out.println("Retrieving all customers ...");
		long start = System.currentTimeMillis();

		// before lazy loading account took huge time
		List<Customer> customers = customerRepository.findAll();
		long finish = System.currentTimeMillis();
		long timeElapsed = finish - start;
		System.out.println("To retrieve all Customers took "+timeElapsed+" ms");
	}

	private void updateCustomers() {
		System.out.println("Change the name of all customers ...");
		long start = System.currentTimeMillis();

		// takes huge time
//		List<Customer> customers = customerRepository.findAll();
//		for(Customer c: customers){
//			c.setName("James Bond");
//			customerRepository.save(c);
//		}
		customerRepository.setNameForAllCustomer("James Bond");
		long finish = System.currentTimeMillis();
		long timeElapsed = finish - start;
		System.out.println("To change the name of all customers took "+timeElapsed+" ms");
	}
}
