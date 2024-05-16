package designPatterns.labs.lab09;

public class Main {

    public static void main(String[] args){
        ComplexClassInterface c = ComplexClassProxy.getProxy();
        c.veryComplicatedTask();

        c.veryComplicatedTask();
    }
}
