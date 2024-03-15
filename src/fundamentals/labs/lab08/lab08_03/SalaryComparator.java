package fundamentals.labs.lab08.lab08_03;

import java.util.Comparator;
import java.util.Date;

public class SalaryComparator implements Comparator<Employee> {

    public int compare(Employee e1, Employee e2) {
        int salary1 = e1.getSalary();
        int salary2 = e2.getSalary();
        return Integer.compare(salary1,salary2);
    }
}
