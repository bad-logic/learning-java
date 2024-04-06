package modernpractises.labs.lab02.Prob2B;

public class OrderLine {
    private int orderlineNum;
    private double price;
    private double quantity;
    private Order order;

   OrderLine(Order ord,int orderlineNum, double price, double quantity){
       this.order = ord;
       this.orderlineNum = orderlineNum;
       this.price = price;
       this.quantity = quantity;
   }

   public int getOrderLineNum(){
       return this.orderlineNum;
   }
   public double getPrice(){
       return this.price;
   }
   public double getQuantity(){
       return this.quantity;
   }

   public String toString(){
       return "Item: { orderlinenum: " + this.getOrderLineNum() + ", price: " + this.getPrice() + ", quantity: " +  this.getQuantity() +" }";
   }

}
