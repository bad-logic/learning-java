package fundamentals.labs.lab08.lab08_03;

import java.util.Comparator;
import java.util.Date;

public class SalaryComparator implements Comparator<Employee> {

    public int compare(Employee e1, Employee e2) {
        int salaryComparison = Integer.compare(e1.getSalary(), e2.getSalary());
        if (salaryComparison != 0) {
            return salaryComparison;
        }
        // If salaries are equal, compare by name
        return e1.getName().compareTo(e2.getName());
    }
}
