package designPatterns.visitorPattern.usingCustomInterface;

public class PrintingVisitor implements Visitor{

    /**
     * @param c
     */
    @Override
    public void visit(Component c) {
        System.out.println("--- file >>  "+ c.getName());
    }

    public void visit(File c) {
        System.out.println("--- file >>  "+ c.getName());
    }

    public void visit(Link c) {
        System.out.println("--- Link >>  " + c.getName() + ", link:" + c.getLink());
    }

    public void visit(Directory c) {
        System.out.println("-- dir >> " + c.getName());
    }

    public void visit(Drive c) {
        System.out.println("-- drive >> " + c.getName());
    }


}
