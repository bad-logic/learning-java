package modernProgrammingPractises.labs.lab02.Prob2A;

public class Student {
    private String name;
    private GradeReport report;


    public Student(String name){
        this.name = name;
        report = new GradeReport(this);
    }

    public String getName(){
        return name;
    }
    public  GradeReport getReport(){
        return report;
    }

    @Override
    public String toString() {
        return "Student: { name: " + name + ", Grade Report: " + report.getGrade() + "}";
    }
}
