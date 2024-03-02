package fundamentals.labs.lab02_01;


public class Customer {
	
	private String firstName;
	private String lastName;
	private String socSecurityNum;
	private Address billingAddress;
	private Address shippingAddress;
	
	public Customer(String fName, String lName) {
		firstName = fName;
		lastName = lName;
	}
	
	
	/** Provides a string representation of this Customer */
	public String toString() {
		return "[" + firstName + ", " + lastName + ", ssn:" + socSecurityNum + "]";
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getSocSecurityNum() {
		return socSecurityNum;
	}
	
	public void setSocSecurityNum(String socSecurityNum) {
		this.socSecurityNum = socSecurityNum;
	}
	
	public Address getBillingAddress() {
		return billingAddress;
	}
	
	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}
	
	public Address getShippingAddress() {
		return shippingAddress;
	}
	
	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	
	public static void main(String[] args) {
		Customer[] cust = new Customer[2];
		Address shipping = new Address("111 Washington Ave", 
				"Fairfield", "IA", "52556");
		Address billing = new Address("3434 Chicago AVe", 
				"Chicago", "IA", "52556");
		Address billing1 = new Address("111 Washington Ave", 
				"Fairfield", "IA", "52556");
		
		Customer cust1 = new Customer("Osama","MAhmoud");
		Customer cust2 = new Customer("Divesh","Mittal");
		
		cust1.setSocSecurityNum("3444-5666-33");
		cust1.setBillingAddress(billing);
		cust1.setShippingAddress(shipping);
		
		cust2.setSocSecurityNum("35244-5666-11");
		cust2.setBillingAddress(billing1);
		cust2.setShippingAddress(shipping);
		
		cust[0] = cust1;
		cust[1] = cust2;
		String city = "Chicago";
		
		for(int i=0;i<cust.length;i++){
			Customer customer = cust[i];
			
			String customerCity = customer.getBillingAddress().getCity();
			
			if(city.equals(customerCity)) {
				System.out.println(cust[i].toString());				
			}
		}
		
	}
	
}