package fundamentals.labs.lab04.lab04_01;

import java.time.LocalDate;

public class DeptEmployee {
    protected String name;
    protected double salary;
    protected  LocalDate hireDate;

    public DeptEmployee(String name,double salary,int hireYear, int hireMonth, int hireDate){
        this.name = name;
        this.salary = salary;
        this.hireDate = LocalDate.of(hireYear,hireMonth,hireDate);
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public LocalDate getHireDate(){
        return LocalDate.of(this.hireDate.getYear(),this.hireDate.getMonth(),this.hireDate.getDayOfMonth());
    }

    public void setHireDate(int hireYear, int hireMonth, int hireDate){
        this.hireDate = LocalDate.of(hireYear,hireMonth,hireDate);
    }

    public double computeSalary(){
        return this.salary;
    }
}
