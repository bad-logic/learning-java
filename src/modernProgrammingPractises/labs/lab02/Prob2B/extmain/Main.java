package modernProgrammingPractises.labs.lab02.Prob2B.extmain;

import modernProgrammingPractises.labs.lab02.Prob2B.Order;
import modernProgrammingPractises.labs.lab02.Prob2B.OrderFactory;

public class Main {
    public static void main(String[] args){
        Order order = OrderFactory.createOrder();
        order.addOrderLines(2, 22, 48);
        order.addOrderLines(4, 27, 49);
        order.addOrderLines(6, 30, 65);

        System.out.println(order);
    }
}
