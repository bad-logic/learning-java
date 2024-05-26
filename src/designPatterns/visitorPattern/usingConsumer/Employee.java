package designPatterns.visitorPattern.usingConsumer;

import java.util.function.Consumer;

public class Employee implements Hire{
    private double salary;
    private String name;

    Employee(String name, double salary){
        this.name = name;
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public String getName() {
        return this.name;
    }

    /**
     * @param action
     */
    @Override
    public void visit(Consumer<Hire> action) {
        action.accept(this);
    }
}
