package designPatterns.visitorPattern.usingCustomInterface;

public interface Visitor {

    default void visit(Directory c){
        visit((Component) c);
    };

    default void visit(File c){
        visit((Component) c);
    };

    default void visit(Link c){
        visit((Component) c);
    };

    default void visit(Drive c){
        visit((Component) c);
    };

    void visit(Component c);
}

