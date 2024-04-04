package modernpractises.labs.lab03.lab03_01.soln;

public class PersonWithJob {
	
	private double salary;
	private Person person;
	
	public double getSalary() {
		return salary;
	}

	PersonWithJob(String n, double s) {
		this.person = new Person(n);
		this.salary = s;
	}
	
	@Override
	public boolean equals(Object aPersonWithJob) {
		if(aPersonWithJob == null) return false;
		if(!(aPersonWithJob instanceof PersonWithJob)) return false;
		PersonWithJob p = (PersonWithJob)aPersonWithJob;
		return this.person.equals(p.person) && this.getSalary() == p.getSalary();
	}

	public static void main(String[] args) {
		PersonWithJob p1 = new PersonWithJob("Joe", 30000);
		PersonWithJob p2 = new PersonWithJob("Joe", 30000);

		System.out.println("p1.equals(p2)? " + p1.equals(p2));
		System.out.println("p2.equals(p1)? " + p2.equals(p1));
	}


}
