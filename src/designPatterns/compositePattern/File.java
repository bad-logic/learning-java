package designPatterns.compositePattern;

public class File implements Component {
    protected String name;

    public File(String name) {
        this.name = name;
    }

    public int getCount() {
        return 1;
    }

    public void print(){
        System.out.println("--- file >>  "+this.name);
    }
}