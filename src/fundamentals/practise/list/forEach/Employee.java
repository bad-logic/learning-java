package fundamentals.practise.list.forEach;

public class Employee {

    private String name;
    private int salary;
    public Employee(String name, int sal) {
        this.name = name;
        this.salary = sal;
    }
    public String getName() {
        return name;
    }
    public int getSalary() {
        return salary;
    }
    @Override
    public String toString() {
        return name + ": " + salary;
    }

    public boolean equals(Employee emp) {
        if(emp == null) return false;
        if(emp.getClass() != getClass()) return false;
        return name.equals(emp.name) && salary == emp.salary;
    }


}
