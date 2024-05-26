package designPatterns.visitorPattern.usingConsumer;

import java.util.function.Consumer;

public class SalaryCounter implements Consumer<Hire> {

    private double salary;

    public double getTotalSalary() {
        return this.salary;
    }

    /**
     * Performs this operation on the given argument.
     *
     * @param hire the input argument
     */
    @Override
    public void accept(Hire hire) {
        this.salary += hire.getSalary();
    }
}
