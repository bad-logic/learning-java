package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


@Entity
@NamedQuery(name="Customer.getAllCustomersFromCountry",query ="select c from Customer c where LOWER(c.address.country)=LOWER(:country)")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String firstname;
	private String lastname;

	@OneToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	@JoinColumn(name = "address_id")
	private Address address;

	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
	private Collection<Order> orders = new ArrayList<Order>();

	public Customer() {
	}

	public Customer(String firstname, String lastname, String street,
			String city, String zip,String country) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = new Address(street, city, zip,country);
	}


	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Collection<Order> getTheOrders() {
		return Collections.unmodifiableCollection(orders);
	}

	
	public boolean addOrder(Order order) {
		boolean added = orders.add(order);
		if (added) {
			order.setCustomer(this);
		}
		return added;
	}

	public boolean removeOrder(Order order) {
		boolean removed = orders.remove(order);
		if (removed) {
			orders.remove(order);
		}
		return removed;
	}

	@Override
	public String toString() {
		return "Customer{" +
				"id=" + id +
				", firstname='" + firstname + '\'' +
				", lastname='" + lastname + '\'' +
				", address=" + address +
				'}';
	}
}
