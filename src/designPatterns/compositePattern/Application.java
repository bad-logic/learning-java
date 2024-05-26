package designPatterns.compositePattern;

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

        System.out.println("items in cdrive: " + cdrive.getCount());

        System.out.println("items in datadir: " + datadir.getCount());

        System.out.println("cdrive contents:");
        cdrive.print();

        System.out.println("datadir contents:");
        datadir.print();

    }
}