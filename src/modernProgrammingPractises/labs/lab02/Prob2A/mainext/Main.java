package modernProgrammingPractises.labs.lab02.Prob2A.mainext;

import modernProgrammingPractises.labs.lab02.Prob2A.Student;

public class Main {
    public static void main(String[] args){
        Student student = new Student("John");

        student.getReport().setGrade("A");
        System.out.print(student);
    }
}
