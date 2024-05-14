package designPatterns.labs.lab07;

public interface Component {
    void print();
    default void addComponent(Component cmp){};
    long getSizeInBytes();
}
