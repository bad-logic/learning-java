package designPatterns.labs.lab09;

public class Main {

    public static void main(String[] args){
        ComplexClassInterface c = ComplexClassVirtualProxy.getProxy();
        c.veryComplicatedTask();

        c.veryComplicatedTask();
    }
}
