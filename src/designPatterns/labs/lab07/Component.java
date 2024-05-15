package designPatterns.labs.lab07;

public interface Component {
    void print();
    default void addComponent(Component cmp){
        throw new UnsupportedOperationException();
    };
    long getSizeInBytes();
}
