package fundamentals.practise.exercisesecurityflaw;

public class Company {
    private String address;
    private Employee president;
    private int numEmployees;
    public Company(String addr, Employee pres, int num) {
        address = addr;
        president = pres;
        numEmployees = num;
    }
    public String getAddress() {
        return address;
    }
    public Employee getPresident() {
        // return president; //  this is the flaw since someone could get employee and set its salary from setter
        return new Employee(president.getName(),president.getSalary());
    }
    public int getNumEmployees() {
        return numEmployees;
    }
}
