package fundamentals.practise.test1;

public class BusinessClass implements BoardingTime {

	Status status;


	public BusinessClass(Status status) {
		super();
		this.status = status;
	}

	public double computeBoardingTime() {
		switch (status) {
		case GOLD:
			return 10;
		case SILVER:
			return 20;
		default:
			return 30;
		}
	}

}
