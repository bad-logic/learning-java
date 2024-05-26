package designPatterns.visitorPattern.usingCustomInterface;

public class Directory extends Drive {

    public Directory(String name) {
        super(name);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);

        for(Component c: this.getComponents()){
            c.accept(visitor);
        }
    }

}