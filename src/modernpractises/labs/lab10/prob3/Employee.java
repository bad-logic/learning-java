package modernpractises.labs.lab10.prob3;

public class Employee {
    private String name;
    private double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName(){
        return this.name;
    }

    public double getSalary(){
        return this.salary;
    }

    @Override
    public boolean equals(Object o){
        if(o==null) return false;
        if(o.getClass() != this.getClass()){
            return false;
        }
        Employee e = (Employee) o;
        return e.getName().equals(this.getName()) && e.getSalary() == this.getSalary();
    }
}
