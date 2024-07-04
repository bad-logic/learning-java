package app;
import java.util.Optional;

import app.domain.Book;
import app.domain.Customer;
import app.repositories.BookRepository;
import app.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class CustomerApplication implements CommandLineRunner{
	
	@Autowired
	CustomerRepository customerrepository;

	@Autowired
	BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		customerrepository.save(new Customer("Jack", "Bauer", "jack@acme.com"));
		customerrepository.save(new Customer("Chloe", "O'Brian", "chloe@acme.com"));
		customerrepository.save(new Customer("Kim", "Bauer", "kim@acme.com"));
		customerrepository.save(new Customer("David", "Palmer", "dpalmer@gmail.com"));
		customerrepository.save(new Customer("Michelle", "Dessler", "mich@hotmail.com"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : customerrepository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer by ID
		Optional<Customer> custOpt = customerrepository.findById(1L);
		Customer customer = custOpt.get();
		System.out.println("Customer found with findOne(1L):");
		System.out.println("--------------------------------");
		System.out.println(customer);
		System.out.println();

		System.out.println("\n\n\n------------BOOKS-----------");
		bookRepository.save(new Book("MyFirstBook", "MFB22", "Ben", 45.87));
		bookRepository.save(new Book("Design Patterns", "DPS34", "Tom", 50));
		bookRepository.save(new Book("System Design", "SD90", "Jack", 24.55));

		System.out.println("\n\n--------findAll()--------------");
		System.out.println(bookRepository.findAll());

		System.out.println("\n\n--------update with id 1--------------");
		System.out.println("Updating a book price with id 1");
		Book  book = bookRepository.findById(1L).get();
		book.setPrice(125.00);
		book.setAuthor("Dan");
		bookRepository.save(book);
		book = bookRepository.findById(1L).get();
		System.out.println("Updated book" + book + "\n");

		// fetch an individual customer by ID
		Optional<Book> bookOptional = bookRepository.findById(2L);
		book = bookOptional.get();
		System.out.println("\n\n---------------Book found with findOne(2)-----------------");
		System.out.println(book);
		System.out.println();

		System.out.println("\n\n--------------Deleting a book with id 3------------------");
		book = bookRepository.findById(3L).get();
		bookRepository.delete(book);

		System.out.println("\n\nprint all books after deletion");
		System.out.println("\n--------findAll()--------------");
		System.out.println(bookRepository.findAll());

	}
}
