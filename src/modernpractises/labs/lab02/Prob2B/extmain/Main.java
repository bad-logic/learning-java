package modernpractises.labs.lab02.Prob2B.extmain;

import modernpractises.labs.lab02.Prob2B.Order;
import modernpractises.labs.lab02.Prob2B.OrderFactory;

public class Main {
    public static void main(String[] args){
        Order order = OrderFactory.createOrder(1,33.98,78);
        order.addOrderLines(2, 22, 48);
        order.addOrderLines(4, 27, 49);
        order.addOrderLines(6, 30, 65);

        System.out.println(order);
    }
}
