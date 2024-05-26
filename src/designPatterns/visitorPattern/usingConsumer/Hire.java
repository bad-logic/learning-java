package designPatterns.visitorPattern.usingConsumer;

import java.util.function.Consumer;

public interface Hire {
    double getSalary();
    String getName();
    void visit(Consumer<Hire> action);
}
