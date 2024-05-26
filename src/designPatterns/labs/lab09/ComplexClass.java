package designPatterns.labs.lab09;

public class ComplexClass implements ComplexClassInterface{

        public ComplexClass() throws InterruptedException {
            super();
            Thread.sleep(10000);
        }

        @Override
        public void veryComplicatedTask() {
            System.out.println("Very complicated task...");
        }

}
