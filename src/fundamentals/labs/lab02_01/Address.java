package fundamentals.labs.lab02_01;


public class Address {
	private String street;
	private String city;
	private String state;
	private String zip;
	
	public Address(String str, String cit, String st, String z) {
		street = str;
		city = cit;
		state = st;
		zip = z;
	}
	
	/**
	 * Provides a string representation of an address.
	 */
	public String toString() {
		return street + ", " + city + ", "+ state + " " + zip;
	}
	public String getStreet() {
		return street;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public String getZip() {
		return zip;
	}
	
	public static void main(String[] args) {
		Address a = new Address("111 Washington Ave", 
				"Fairfield", "IA", "52556");
		//Prints address to the console
		System.out.println(a.toString());
	}
}

