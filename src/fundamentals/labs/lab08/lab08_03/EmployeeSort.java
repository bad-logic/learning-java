package fundamentals.labs.lab08.lab08_03;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EmployeeSort {

    public static void main(String[] args) {
        new EmployeeSort();
    }
    public EmployeeSort() {
        Employee[] empArray =
                {new Employee("George", 40000, 1996,11,5),
                        new Employee("Dave", 50000, 2000, 1, 3),
                        new Employee("Richard", 45000, 2001, 2, 7)};
        List<Employee> empList = Arrays.asList(empArray);
        NameComparator nameComp =
                new NameComparator();
        System.out.println("Sorting by name");
        Collections.sort(empList, nameComp);
        System.out.println(empList);

        System.out.println("Sorting by salary");
        Collections.sort(empList, new SalaryComparator());
        System.out.println(empList);

        System.out.println("Sorting by hire date");
        Collections.sort(empList, new HireDateComparator());
        System.out.println(empList);
    }

}

