package modernpractises.labs.lab03.lab03_03;


public class Trailer extends Property{
	private static final double RENT = 500;
	public Trailer(Address address) {
		super(address);
	}
	public double computeRent(){
		return RENT;
	}
	
}
