package modernpractises.labs.lab02.Prob2B;

public class OrderLine {
    private int orderlineNum;
    private double price;
    private double quantity;

   OrderLine(int orderlineNum, double price, double quantity){
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
