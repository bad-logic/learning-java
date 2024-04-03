package modernProgrammingPractises.labs.lab02.Prob2B;

public class OrderLine {
    private int orderlineNum;
    private double price;
    private double quantity;

   OrderLine(int orderlineNum, double price, double quantity){
       this.orderlineNum = orderlineNum;
       this.price = price;
       this.quantity = quantity;
   }

   public int getOrderlineNum(){
       return orderlineNum;
   }
   public double getPrice(){
       return price;
   }
   public double getQuantity(){
       return quantity;
   }

}
