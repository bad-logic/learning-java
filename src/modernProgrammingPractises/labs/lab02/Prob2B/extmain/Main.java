package modernProgrammingPractises.labs.lab02.Prob2B.extmain;

import modernProgrammingPractises.labs.lab02.Prob2B.Order;

public class Main {
    public static void main(String[] args){
        Order order = new Order(1, 2024,2,24);
        order.addOderLines(2, 22, 48);
        order.addOderLines(4, 27, 49);
        order.addOderLines(6, 30, 65);

        System.out.println(order);
    }
}
