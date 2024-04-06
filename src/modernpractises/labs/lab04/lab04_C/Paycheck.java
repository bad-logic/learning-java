package modernpractises.labs.lab04.lab04_C;

public final class Paycheck {
	private final double grossPay;
	private final double fica;
	private final double state;
	private final double local;
	private final double medicare;
	private final double socialSecurity;
	
	public Paycheck(double grossPay, double fica, double state, double local, double medicare, double socialSecurity) {
		this.grossPay = grossPay;
		this.fica = fica / 100;
		this.state = state / 100;
		this.local = local / 100;
		this.medicare = medicare / 100;
		this.socialSecurity = socialSecurity / 100;
	}
	
	
	public String print() {		
			return	"Paystub:\n" +
				"GrossPay: " + grossPay + "\n" +		
				"Fica: " + fica + "\n" +		
				"State: " + state + "\n" +		
				"Local: " + local + "\n" +		
				"Medicare: " + medicare + "\n" +		
				"Social Security: " + socialSecurity + "\n" +		
				"NET PAY: " + getNetPay();
			
	}
	
	public double getNetPay() {
		return grossPay - grossPay * (this.fica + this.state + this.local + this.medicare + this.socialSecurity);
	}
	
	@Override
	public String toString() {
		return print();
	}
}
