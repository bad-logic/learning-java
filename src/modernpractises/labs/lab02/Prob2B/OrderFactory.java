package modernpractises.labs.lab02.Prob2B;

public class OrderFactory {
    public static Order createOrder(int orderNum, double price, double quantity){
        return new Order(1, 2024,2,24,price,quantity);
    }
}
