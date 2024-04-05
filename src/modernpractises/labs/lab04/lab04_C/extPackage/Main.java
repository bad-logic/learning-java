package modernpractises.labs.lab04.lab04_C.extPackage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import modernpractises.labs.lab04.lab04_C.Commissioned;
import modernpractises.labs.lab04.lab04_C.Employee;
import modernpractises.labs.lab04.lab04_C.EmployeeFactory;
import modernpractises.labs.lab04.lab04_C.Hourly;
import modernpractises.labs.lab04.lab04_C.Order;
import modernpractises.labs.lab04.lab04_C.Salaried;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Order> list = new ArrayList<>(); 
        list.add(EmployeeFactory.createOrder("100",LocalDate.of(2023, 2, 1),200)); 
        list.add(EmployeeFactory.createOrder("100",LocalDate.of(2023, 2, 10),100)); 
        list.add(EmployeeFactory.createOrder("100",LocalDate.of(2023, 3, 10),100)); 
        Commissioned cm = EmployeeFactory.createCommissioned("123",0.8,500,list); 
        Employee[] emp = { EmployeeFactory.createSalaried("121",4000), EmployeeFactory.createHourly("122",15.67,20),cm}; 
        for(Employee e :emp){ 
         e.print(3,2023); 
        }
	}

}
