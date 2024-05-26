package designPatterns.visitorPattern.usingCustomInterface;

public class CountingVisitor implements Visitor{

    int count = 0;

    public int getCount() {
        return this.count;
    }

    /**
     * @param c
     */
    @Override
    public void visit(Component c) {
        count++;
    }

//    /**
//     * @param c
//     */
//    @Override
//    public void visit(File c) {
//        count++;
//    }
//
//    /**
//     * @param c
//     */
//    @Override
//    public void visit(Link c) {
//        count++;
//    }
//
//    /**
//     * @param c
//     */
//    @Override
//    public void visit(Drive c) {
//        count++;
//    }
//
//    /**
//     * @param c
//     */
//    @Override
//    public void visit(Directory c) {
//        count++;
//    }
}
