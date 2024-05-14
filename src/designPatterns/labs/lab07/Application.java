package designPatterns.labs.lab07;

public class Application {
    public static void main(String[] args) {
        Drive cdrive = new Drive("C");

        Directory appdir = new Directory("applications");
        Directory datadir = new Directory("my data");
        Directory coursedir = new Directory("cs525");

        File excelfile = new File("msexcel.exe", 2353256);
        File wordfile = new File("msword.exe", 3363858);
        File studentsfile = new File("students.doc", 34252);

        Link googleDrive = new Link("mydrive","https://www.drivegoogle.com/zyd", 344345);
        cdrive.addComponent(googleDrive);
        cdrive.addComponent(appdir);
        cdrive.addComponent(datadir);
        datadir.addComponent(coursedir);
        appdir.addComponent(excelfile);
        appdir.addComponent(wordfile);
        coursedir.addComponent(studentsfile);
        cdrive.print();
    }
}