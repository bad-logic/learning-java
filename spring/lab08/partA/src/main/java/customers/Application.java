package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
        // create customer
		Customer customer = new Customer(101,"John doe", "johnd@acme.com", "0622341678");
		CreditCard creditCard = new CreditCard("12324564321", "Visa", "11/23");
		customer.setCreditCard(creditCard);
		customerRepository.save(customer);
		customer = new Customer(109,"John Jones", "jones@acme.com", "0624321234");
		creditCard = new CreditCard("657483342", "Visa", "09/23");
		customer.setCreditCard(creditCard);
		customerRepository.save(customer);
		customer = new Customer(66,"James Johnson", "jj123@acme.com", "068633452");
		creditCard = new CreditCard("99876549876", "MasterCard", "01/24");
		customer.setCreditCard(creditCard);
		customerRepository.save(customer);
		//get customers
		System.out.println(customerRepository.findById(66).get());
		System.out.println(customerRepository.findById(101).get());
		System.out.println("-----------All customers ----------------");
		System.out.println(customerRepository.findAll());
		//update customer
		customer = customerRepository.findById(101).get();
		customer.setEmail("jd@gmail.com");
		customerRepository.save(customer);
		System.out.println("-----------find by phone ----------------");
		System.out.println(customerRepository.findByPhone("0622341678"));
		System.out.println("-----------find by email ----------------");
		System.out.println(customerRepository.findCustomerWithEmail("jj123@acme.com"));
		System.out.println("-----------find customers with a certain type of creditcard ----------------");
		List<Customer> customers = customerRepository.findByCreditCardType("Visa");
		for (Customer cust : customers){
			System.out.println(cust);
		}

		Student st = new Student(101,"Ben","9082840238409324", new Address("4th ave","newyork","32423"));
		st.addGrade(new Grade("AI","A+"));
		st.addGrade(new Grade("Spring","B+"));
		st.addGrade(new Grade("ASD","A+"));

		Student st1 = new Student(102,"Jazmine","75464345564565", new Address("4th ave","sanfransisco","56756"));
		st1.addGrade(new Grade("AI","A"));
		st1.addGrade(new Grade("Spring","A"));
		st1.addGrade(new Grade("ASD","A"));

		Student st2 = new Student(103,"James","4989247948345", new Address("4th ave","sanfransisco","84578"));
		st2.addGrade(new Grade("AI","B+"));
		st2.addGrade(new Grade("Spring","A"));
		st2.addGrade(new Grade("ASD","A"));

		Student st3 = new Student(104,"Tony","09340527843543", new Address("4th ave","seattle","9u9898"));
		Student st4 = new Student(105,"Ben","993458904385", new Address("4th ave","fairfield","928374"));
		st4.addGrade(new Grade("AI","A+"));
		st4.addGrade(new Grade("ASD","A"));
		st4.addGrade(new Grade("Algorithm","A"));

		studentRepository.saveAll(List.of(st,st1,st2,st3,st4));
		System.out.println("----------- Find the Students with a certain name ----------------");
		System.out.println(studentRepository.findByName("Ben"));
		System.out.println("----------- Find the Students with a certain phone number ----------------");
		System.out.println(studentRepository.findByPhone("09340527843543"));
		System.out.println("----------- Find the Students from a certain city ----------------");
		System.out.println(studentRepository.findByAddressCity("sanfransisco"));

		System.out.println("----------- Find the Students that took a certain course with a given name ----------------");
		System.out.println(studentRepository.findByGradesCourseName("Algorithm"));
		System.out.println("----------- Find the Students with an A+ for a certain course name ----------------");
		System.out.println(studentRepository.findByGradesCourseNameAndGradesGrade("AI","A+"));


	}

}
