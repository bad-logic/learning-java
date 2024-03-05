package fundamentals.labs.lab04.lab04_07.employeeinfo;

public class SavingsAccount extends Account {
	private final double MONTHLY_INTEREST_RATE = 0.25;
	public SavingsAccount(Employee e, double startBalance){
		super(e,startBalance);
	}
	public SavingsAccount(Employee e){
		super(e);
	}
	
	public void updateBalance() {
		double baseBalance = super.getBalance();
		double interest = (MONTHLY_INTEREST_RATE/100) * baseBalance;
		setBalance(baseBalance + interest);
	}
	public AccountType getAcctType(){
		return AccountType.SAVINGS;
	}

}
