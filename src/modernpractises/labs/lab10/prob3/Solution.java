package modernpractises.labs.lab10.prob3;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static <T> boolean contains1(List<T> list, T s){
        for(T x:list){
            if(x==null && s==null) return true;
            if(s== null || x==null) continue;
            if(x.equals(s)) return true;
        }
        return false;
    }

    public static void test1(){
        List<String> list = Arrays.asList("Bob","Joe","Tom");
        System.out.println(Solution.<String>contains1(list, "Tom"));
    }

    public static void test2(){
        List<Employee> list = Arrays.asList(new Employee("Bob",4578.00), new Employee("Joe",5500.99), new Employee("Tom",4500.00));
        System.out.println(Solution.<Employee>contains1(list, new Employee("Tom",4500.00)));
        System.out.println(Solution.<Employee>contains1(list, new Employee("Tom",4500.01)));
    }

    public static void test3(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        System.out.println(Solution.<Integer>contains1(list, 44));
    }


    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }
}
