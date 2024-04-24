import java.util.ArrayList;
import java.util.List;

//[25,1,null,0,0,1,null,null,null,0]


class Employee{
    private String name;
    private double salary;

    Employee(String n){
        this.name = n;
    }

    public String getName(){
        return this.name;
    }

    public double getSalary(){
        return this.salary;
    }

    public void setSalary(double s){
        this.salary = s;
    }

    public String toString(){
        return "Employee: name: " + this.getName() + ", salary: "+ this.getSalary();
    }

}
public class Test{

    public static void swapValues(Employee e1,Employee e2){
        Employee temp = e1;
        e1 = e2;
        e2 = temp;
    }

    public static void changeValue(Employee e1){
        e1.setSalary(3400.99);
        e1 = new Employee("Ben");
        e1.setSalary(4500.88);
    }

    public static void main(String[] args){
        Employee e1 = new Employee("Bar");
        Employee e2 = new Employee("Foo");
        System.out.println("e1 before swap: "+e1);
        System.out.println("e2 before swap: "+e2);
        swapValues(e1,e2);
        System.out.println("e1 after swap: "+e1);
        System.out.println("e2 after swap: "+e2);

        changeValue(e1);
        System.out.println("e1 after changing value: "+e1);
    }
}
