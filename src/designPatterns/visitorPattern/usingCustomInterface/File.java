package designPatterns.visitorPattern.usingCustomInterface;

public class File implements Component {
    protected String name;

    public File(String name) {
        this.name = name;
    }

    /**
     * @return
     */
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}