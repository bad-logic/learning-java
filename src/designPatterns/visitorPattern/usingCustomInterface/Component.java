package designPatterns.visitorPattern.usingCustomInterface;

public interface Component {
    default void addComponent(Component cmp){
        throw new UnsupportedOperationException();
    };
    String getName();
    void accept(Visitor visitor);
}
