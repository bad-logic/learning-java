package designPatterns.visitorPattern.usingConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Manager implements Hire{
    private double salary;
    private String name;
    private List<Hire> emps = new ArrayList<Hire>();

    Manager(String name, double salary){
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

    public void addHires(Hire hire){
        this.emps.add(hire);
    }

    /**
     * @param action
     */
    @Override
    public void visit(Consumer<Hire> action) {
        action.accept(this);
        for(Hire e: this.emps){
            e.visit(action);
        }
    }
}
