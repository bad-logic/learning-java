package app;

import domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repositories.*;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("domain")
@ComponentScan("repositories")
public class OrderApplication implements CommandLineRunner{

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CdRepository cdRepository;

	@Autowired
	private AddressRepository addressRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Cd cd = new Cd();
		cd.setName("Hibernate 3");
		cd.setDescription("Good book on Hibernate");
		cd.setPrice(8.99);
		cd.setArtist("U2");
		OrderLine ol1 = new OrderLine(2, cd);

		Dvd dvd = new Dvd();
		dvd.setName("Rocky3");
		dvd.setDescription("Album from 1995");
		dvd.setPrice(12.98);
		dvd.setGenre("Comedy");
		OrderLine ol2 = new OrderLine(4, dvd);

		Book book = new Book();
		book.setName("The best of Queen");
		book.setDescription("Album from 1995");
		book.setPrice(12.98);
		book.setIsbn("56-Eb");
		OrderLine ol3 = new OrderLine(4, book);

		Order o1 = new Order("234743", "12/10/06", "open");
		o1.addOrderLine(ol1);
		o1.addOrderLine(ol2);
		o1.addOrderLine(ol3);

		Customer c1 = new Customer("Frank", "Brown", "Mainstreet 1",
				"Amsterdam", "2389HJ","usa");
		c1.addOrder(o1);
		o1.setCustomer(c1);

		this.orderRepository.save(o1);

		System.out.println("\n----------- Fetching orders -------------");
		System.out.println(this.orderRepository.findAll());

		System.out.println("\n------------ Using method Based queries -------------");
		System.out.println("Give All customers\n"+this.customerRepository.findAll());
		System.out.println("Give all CD’s from U2 with a price smaller than 10 euro\n"+this.cdRepository.findByArtistAndPriceLessThan("U2",10));
		System.out.println("Give all customers with zip code 2389HJ\n"+this.customerRepository.findByAddressZip("2389HJ"));
		System.out.println("Give all customers who ordered a DVD with the name Rocky3\n"+this.customerRepository.findDistinctByOrdersOrderlinesProductTypeAndOrdersOrderlinesProductName("DVD","Rocky3"));


		System.out.println("\n------------ Using named queries -------------");
		System.out.println("Give All customers  from USA\n"+this.customerRepository.getAllCustomersFromCountry("USA"));
		System.out.println("Give all CD’s from a certain artist\n"+this.cdRepository.getAllCdsFromArtist("U23"));

		System.out.println("\n------------ Using JPQL queries -------------");
		System.out.println("Give the order numbers of all orders with status ‘closed’\n"+this.orderRepository.getOrderNumbersOfClosedOrders());
		System.out.println("Give the first and lastnames of all customers who live in Amsterdam\n");

		for (Object[] customer : this.customerRepository.getFirstAndLastNameOfCustomerFromCity("Amsterdam")) {
			String firstName = (String) customer[0];
			String lastName = (String) customer[1];
			System.out.println("First Name: " + firstName + ", Last Name: " + lastName);
		}
		System.out.println("Give the ordernumbers of all orders from customers who live in a certain city (city is a parameter)\n"+this.orderRepository.getOrderNumberOfCustomersFromCity("Amsterdam"));
		System.out.println("Give all CD’s from a certain artist with a price bigger than a certain amount (artist and\n" +
				"amount are parameter2)\n"+this.cdRepository.getAllCdsByArtistAndPriceGreaterThan("U2",8.98));


		System.out.println("\n------------ Using Native queries -------------");
		System.out.println("Give all addresses in Amsterdam.\n"+this.addressRepository.getAllAddressesFromAmsterdam());
		System.out.println("Give all CD’s from U2.\n"+this.cdRepository.getAllCdsByArtistU2());

		System.out.println("\n------------ Using Specification queries -------------");

		System.out.println("Give the ordernumbers of all orders with status ‘closed’\n"+this.orderRepository.findAll(OrdersSpecifications.withStatusClosed()).stream().map(Order::getOrdernr).toList());
		System.out.println("Give all customers who live in Amsterdam.\n"+this.customerRepository.findAll(CustomerSpecification.whoLiveInAmsterdam()));
		System.out.println("Give all CD’s from a certain artist with a price bigger than a certain amount (artist and\n" +
				"amount are parameter2)\n"+this.cdRepository.findAll(Specification.where(CdSpecifications.byArtist("u2")).and(CdSpecifications.hasPriceGreaterThan(8.98))));
	}


}
