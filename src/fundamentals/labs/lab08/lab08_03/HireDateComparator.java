package fundamentals.labs.lab08.lab08_03;

import java.util.Comparator;
import java.util.Date;

public class HireDateComparator implements Comparator<Employee> {

    public int compare(Employee e1, Employee e2) {
        int hireDateComparison = e1.getHireDate().compareTo(e2.getHireDate());
        if (hireDateComparison != 0) {
            return hireDateComparison;
        }
        // If hire dates are equal, compare by name
        int nameComparison = e1.getName().compareTo(e2.getName());
        if( nameComparison != 0){
            return nameComparison;
        };

        return Integer.compare(e1.getSalary(), e2.getSalary());
    }

}
