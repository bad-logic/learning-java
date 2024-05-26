package designPatterns.compositePattern;

public interface Component {
    default void addComponent(Component cmp){
        throw new UnsupportedOperationException();
    };
    void print();
    int getCount();
}
