package designPatterns.visitorPattern.usingCustomInterface;

public class Application {
    public static void main(String[] args) {

        Directory appdir = new Directory("applications");
        File excelfile = new File("msexcel.exe");
        File wordfile = new File("msword.exe");
        appdir.addComponent(excelfile);
        appdir.addComponent(wordfile);


        Directory datadir = new Directory("my data");
        Directory coursedir = new Directory("cs525");
        File studentsfile = new File("students.doc");
        coursedir.addComponent(studentsfile);
        datadir.addComponent(coursedir);

        Drive cdrive = new Drive("C");
        Link googleDrive = new Link("mydrive","https://www.drivegoogle.com/zyd");

        cdrive.addComponent(appdir);
        cdrive.addComponent(datadir);
        cdrive.addComponent(googleDrive);

        CountingVisitor c = new CountingVisitor();
        cdrive.accept(c);

        System.out.println("C drive items count: " + c.getCount());

        cdrive.accept(new PrintingVisitor());


    }
}