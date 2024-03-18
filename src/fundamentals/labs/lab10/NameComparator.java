package fundamentals.labs.lab10;

import java.util.Comparator;
public class NameComparator implements Comparator<Employee> {
	//compareTo in this case is not consistent with equals
	public int compare(Employee e1, Employee e2) {
		return e1.getName().compareTo(e2.getName());
	}

}
