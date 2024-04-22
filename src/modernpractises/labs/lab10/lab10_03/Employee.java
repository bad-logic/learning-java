package modernpractises.labs.lab10.lab10_03;

public class Employee {
	String firstName, lastName;
	

	int salary;
	public Employee(String f, String l, int s) {
		this.firstName = f;
		this.lastName = l;
		this.salary = s;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("<");
		sb.append("first name: ");
		sb.append(firstName);
		sb.append(" last name: ");
		sb.append(lastName);
		sb.append(" salary: ");
		sb.append("" + salary+">");
		return sb.toString();
		
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

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if(o.getClass() != this.getClass()) return false;
        Employee e = (Employee) o;

        return e.firstName.equals(this.firstName) && e.lastName.equals(this.lastName) && e.salary == this.salary;
    }
}
