package modernpractises.labs.lab10.lab10_03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    
    public static <T> boolean contains1(List<T> list, T s) {
        for(T x: list) {
            if (x == null && s == null) return true;
            if (s == null || x == null) continue;
            if(x.equals(s)) return true;
        }

        return false;
    }

    public static void test1() {
        List<String> list = Arrays.asList("Bob", "Joe", "Tom");
        boolean result = Main.contains1(list, "Tom");
        System.out.println(result);
    }

    public static void test2() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("John", "Cena", 12000));
        list.add(new Employee("John", "Cenas", 12000));
        list.add(new Employee("John", "Cena", 13000));
        boolean result = Main.contains1(list, new Employee("John", "Cenas", 12000) );
        System.out.println(result);
    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}
