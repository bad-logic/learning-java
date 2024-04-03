package modernProgrammingPractises.labs.lab02.Prob2A;

public class GradeReport {
    private String grade;
    private Student owner;

     GradeReport(Student student ){
         owner = student;
     }

     public void setGrade(String grade){
         this.grade = grade;
     }

     public String getGrade(){
         return grade;
     }
     public Student getOwner(){
         return owner;
     }
}
