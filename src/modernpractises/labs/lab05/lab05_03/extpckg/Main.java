package modernpractises.labs.lab05.lab05_03.extpckg;

import modernpractises.labs.lab05.lab05_03.CustOrderFactory;
import modernpractises.labs.lab05.lab05_03.Customer;
import modernpractises.labs.lab05.lab05_03.Order;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Customer cust = CustOrderFactory.createCustomer("Bob");

        Order order = CustOrderFactory.createOrder(LocalDate.now());
        cust.addOrder(order);

        order.addItem(CustOrderFactory.createItem("Shirt"));
        order.addItem(CustOrderFactory.createItem("Laptop"));


        order = CustOrderFactory.createOrder((LocalDate.now()));
        cust.addOrder(order);

        order.addItem(CustOrderFactory.createItem("Pants"));
        order.addItem(CustOrderFactory.createItem("Knife Set"));

        System.out.println(cust.getOrders());
    }


}
