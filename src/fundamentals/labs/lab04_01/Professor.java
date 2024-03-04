package fundamentals.labs.lab04_01;

public class Professor  extends DeptEmployee{

    private int numberOfPublications;
    public Professor(String name,int numberOfPublications,double salary,int hireYear, int hireMonth, int hireDate){
        super( name, salary, hireYear,  hireMonth,  hireDate);
        this.numberOfPublications = numberOfPublications;
    }

    public Professor(String name,double salary,int hireYear, int hireMonth, int hireDate){
        super(name,salary,hireYear,hireMonth,hireDate);
    }

    public int getNumberOfPublications(){
        return this.numberOfPublications;
    }

    public void setNumberOfPublications(int numberOfPublications){
        this.numberOfPublications = numberOfPublications;
    }

}
