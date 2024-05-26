package designPatterns.visitorPattern.usingConsumer;

import java.util.function.Consumer;

public class HireCounter implements Consumer<Hire> {
    private int count;


    public int getHireCount(){
        return this.count;
    }

    /**
     * Performs this operation on the given argument.
     *
     * @param hire the input argument
     */
    @Override
    public void accept(Hire hire) {
        this.count++;
    }
}
