package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private CustomerDAO customerDao;

	@Autowired
	private ProductDAO productDAO;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		customerDao.clearDB();
		Customer customer = new Customer(101,"John doe", "johnd@acme.com", "0622341678");
		CreditCard creditCard = new CreditCard("12324564321", "Visa", "11/23");
		customer.setCreditCard(creditCard);
		customerDao.save(customer);
		customer = new Customer(66,"James Johnson", "jj123@acme.com", "068633452");
		creditCard = new CreditCard("99876549876", "MasterCard", "01/24");
		customer.setCreditCard(creditCard);
		customerDao.save(customer);
		System.out.println(customerDao.getCustomer(101));
		System.out.println(customerDao.getCustomer(66));
		System.out.println("-----------All customers ----------------");
		System.out.println(customerDao.getAllCustomers());


		System.out.println("\n\n-----------Products ----------------");
		productDAO.clearDB();
		Product product = new Product(111,"Tesla", 9000.99);
		productDAO.save(product);

		product = new Product(112,"Porsche", 20456.89);
		Supplier supplier = new Supplier(111, "Ben", "9729837497234");
		product.setSupplier(supplier);
		productDAO.save(product);

		System.out.println("\n\n-----------find by product number 111 ----------------");
		System.out.println(productDAO.findByProductNumber(111));
		System.out.println("\n\n-----------find by product name Tesla ----------------");
		System.out.println(productDAO.findByProductName("Tesla"));
		System.out.println("\n\n-----------All Products ----------------");
		System.out.println(productDAO.getAllProducts());

		System.out.println("\n\n-----------Remove Product 111 ----------------");
		System.out.println("Removed: " + productDAO.removeProduct(111));

		System.out.println("\n\n-----------Remove Non Existing Product 111 ----------------");
		System.out.println("Removed: " + productDAO.removeProduct(111));
	}
}
