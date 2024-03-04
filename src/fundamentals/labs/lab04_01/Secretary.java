package fundamentals.labs.lab04_01;

public class Secretary extends DeptEmployee{

    private double overTimeHours;

    public Secretary(String name,double overtimeHours,double salary,int hireYear, int hireMonth, int hireDate){
        super(name,salary,hireYear,hireMonth,hireDate);
        this.overTimeHours = overtimeHours;
    }

    public Secretary(String name,double salary,int hireYear, int hireMonth, int hireDate){
        super(name,salary,hireYear,hireMonth,hireDate);
    }

    public double getOverTimeHours(){
        return this.overTimeHours;
    }

    public void setOverTimeHours(double hours){
        this.overTimeHours = hours;
    }

    @Override
    public double computeSalary(){
        return this.salary + (12 * this.overTimeHours);
    }
}
