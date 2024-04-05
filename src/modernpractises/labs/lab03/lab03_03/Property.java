package modernpractises.labs.lab03.lab03_03;

public abstract class Property {
	private Address address;
	public Property(Address address) {
		this.address = address;
	}
	public Address getAddress() {
		return address;
	}
	
	abstract double computeRent(); 
}
