package modernpractises.labs.lab02.Prob2B;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Order {
    private int orderNum;
    private Date orderDate;
    private List<OrderLine> orderlines;

    Order(int orderNum, int aYear,
                 int aMonth, int aDay,double price, double quantity){
        this.orderNum = orderNum;
        GregorianCalendar cal = new GregorianCalendar(aYear, aMonth - 1, aDay);
        orderDate = cal.getTime();
        this.orderlines = new ArrayList<>();
        this.addOrderLines(orderNum,price,quantity);
    }

    public void addOrderLines(int orderNum, double price, double quantity){
        OrderLine newOderLine = new OrderLine(this,orderNum, price, quantity);
        orderlines.add(newOderLine);
    }
    public int getOrderNum(){
        return orderNum;
    }

    @Override
    public String toString() {
        String result = "Order No: " + orderNum + " \n" + "Date: " + orderDate +"\n" + "Order Items: \n";
        for (OrderLine orderLine : orderlines) {
            result += orderLine.toString() + "\n";
        }
        return result;

    }
}
