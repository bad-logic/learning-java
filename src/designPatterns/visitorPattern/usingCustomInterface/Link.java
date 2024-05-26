package designPatterns.visitorPattern.usingCustomInterface;

public class Link extends File {
    private String link;


    Link(String name, String link){
        super(name);
        this.link = link;
    }

    public String getLink() {
        return this.link;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
