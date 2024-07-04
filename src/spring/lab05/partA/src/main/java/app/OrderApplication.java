package app;

import domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repositories.OrderRepository;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("domain")
public class OrderApplication implements CommandLineRunner{

	@Autowired
	private OrderRepository orderRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Cd cd = new Cd();
		cd.setName("Hibernate 3");
		cd.setDescription("Good book on Hibernate");
		cd.setPrice(35.50);
		cd.setArtist("Gunther");
		OrderLine ol1 = new OrderLine(2, cd);

		Dvd dvd = new Dvd();
		dvd.setName("The best of Queen");
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
				"New york", "43221","usa");
		c1.addOrder(o1);
		o1.setCustomer(c1);

		this.orderRepository.save(o1);

		System.out.println("\n----------- Fetching orders -------------");
		System.out.println(this.orderRepository.findAll());
	}


}
