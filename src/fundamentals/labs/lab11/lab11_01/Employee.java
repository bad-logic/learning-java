package fundamentals.labs.lab11.lab11_01;

import java.util.HashMap;
import java.util.Map;

public class Employee {
    private String firstName;
    private String lastName;
    private HashMap<String,Double> salaryRecord;

    public Employee(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.salaryRecord = new HashMap<>();
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getFirstName(){
        return this.getFirstName();
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName(){
        return this.getLastName();
    }

    public void addEntry(String date, Double paycheckAmount){
        this.salaryRecord.put(date,paycheckAmount);
    }

    public void printPaymentAmount(String date){
        String output = this.firstName + " " + this.lastName;
        Double sa = this.salaryRecord.get(date);
        if(sa != null){
            output += " was paid " + sa + " on ";
        }else{
            output += " did not receive a paycheck on ";
        }
        output += date;
        System.out.println(output);
    }

    public void printAveragePaycheck(){
        Double avg = 0.0;
        for(Map.Entry<String,Double> entry : this.salaryRecord.entrySet()){
            avg += entry.getValue();
        }
        avg /= this.salaryRecord.size();
        System.out.println("Average paycheck for "+this.firstName + " " + this.lastName + " was " + avg);
    }

    public static void main(String[] args){
        Employee emp = new Employee("Jim","Jones");
        emp.addEntry("1/15/2011",3_005.50);
        emp.addEntry("2/15/2011",3_150.00);
        emp.addEntry("3/15/2011",4_200.00);
        emp.addEntry("4/15/2011",2_988.50);
        emp.addEntry("5/15/2011",3_005.50);
        emp.addEntry("6/15/2011",3_405.99);
        emp.addEntry("8/15/2011",4_005.50);

        emp.printPaymentAmount("2/15/2011");
        emp.printPaymentAmount("9/15/2011");
        emp.printAveragePaycheck();
    }
}
