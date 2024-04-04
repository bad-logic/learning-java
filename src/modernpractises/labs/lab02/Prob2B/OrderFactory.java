package modernpractises.labs.lab02.Prob2B;

public class OrderFactory {
    public static Order createOrder(int orderNum, double price, double quantity){
        Order order = new Order(1, 2024,2,24);
        order.addOrderLines(orderNum,price,quantity);
        return order;
    }
}
