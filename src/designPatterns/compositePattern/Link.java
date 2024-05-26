package designPatterns.compositePattern;

public class Link extends File {
    private String link;

    Link(String name, String link){
        super(name);
        this.link = link;
    }

    @Override
    public void print() {
        System.out.println("--link >> "+ this.name + ", link >> " + this.link);
    }

}
