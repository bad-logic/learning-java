package fundamentals.practise.list.forEach;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Employee> aList = Arrays.asList(new Employee("Bob", 20000),
                new Employee("Harry", 60000), new Employee("Steven", 30000),
                new Employee("Regis", 50000),new Employee("Tony", 40000));
        System.out.println(empsToNames(aList));
    }

    static List<String> empsToNames(List<Employee> list) {
        // use the new forEach method to return in a list
        // the names of the Employees in the input list
        List<String> ls=  new ArrayList<String>();
        list.forEach(item-> ls.add(item.getName()));
        return ls;
    }
}

