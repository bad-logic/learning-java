package modernpractises.labs.lab05.lab05_03;

import java.time.LocalDate;

public class CustOrderFactory {
    private CustOrderFactory(){}
    public static Customer createCustomer(String name){
        if(name == null) throw new NullPointerException("Customer name cannot be null");
        return new Customer( name );
    }

    public static Order createOrder(LocalDate date){
        return new Order(date);
    }

    public static Item createItem(String name){
        return new Item(name);
    }

}
