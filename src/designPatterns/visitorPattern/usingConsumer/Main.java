package designPatterns.visitorPattern.usingConsumer;

public class Main {

    public static void main(String[] args){
        Manager ceo = new Manager("ceo",2234234.324);

        Manager m1 = new Manager("m1",2342.234);
        Manager m2 = new Manager("m2",23423);

        Employee e1 = new Employee("e1",45645);
        Employee e2 = new Employee("e2",45643);
        Employee e3 = new Employee("e3",23423);
        Employee e4 = new Employee("e4",23423);
        Employee e5 = new Employee("e5",23432);

        m1.addHires(e1);
        m1.addHires(e2);

        m2.addHires(e3);
        m2.addHires(e4);

        ceo.addHires(e5);
        ceo.addHires(m1);
        ceo.addHires(m2);

        HireCounter hires = new HireCounter();
        ceo.visit(hires);
        System.out.println(hires.getHireCount());

        SalaryCounter salary = new SalaryCounter();
        ceo.visit(salary);
        System.out.println(salary.getTotalSalary());

    }
}
