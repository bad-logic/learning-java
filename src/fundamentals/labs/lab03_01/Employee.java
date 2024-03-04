package fundamentals.labs.lab03_01;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee {
    // instance fields
    private String name;
    private String nickName;
    private double salary;
    private Date hireDay;

    // constructor
    Employee(String name, String aNickName, double aSalary, int aYear,
             int aMonth, int aDay) {
        this.name = name;
        nickName = aNickName;
        salary = aSalary;
        GregorianCalendar cal = new GregorianCalendar(aYear, aMonth - 1, aDay);
        hireDay = cal.getTime();
    }

    // instance methods
    public String getName() {
        return name;
    }
    public String getNickName() {
        return nickName;
    }
    public void setNickName(String aNickName) {
        nickName = aNickName;
    }
    public double getSalary() {
        return salary;
    }

    public Date getHireDay() {
        GregorianCalendar cal = new GregorianCalendar(this.hireDay.getYear(), this.hireDay.getMonth(), this.hireDay.getDay());
        hireDay = cal.getTime();
        return hireDay;
    }
    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
    private String format = "name = %s, salary = %.2f, hireDay = %s";

    public String toString() {
        return String.format(format, name, salary, Util.dateAsString(hireDay));
    }
}

