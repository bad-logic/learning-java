package fundamentals.labs.lab10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeBst {
    private class Node {
        private Employee element; // The data in the node
        private Node left; // Left child
        private Node right; // Right child

        // Constructors
        Node(Employee theElement) {
            this(theElement, null, null);
        }

        Node(Employee element, Node left, Node right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }

    }

    private Node root;
    private Comparator<Employee> comparator;

    EmployeeBst(Comparator<Employee> comp){
        this.comparator = comp;
        root = null;
    }

    private boolean find(Employee x, Node n){
        if(n == null) return false;
        if(n != null && n.element.equals(x)) return true;
        return (this.comparator.compare(x,n.element) < 0) ?
                find(x,n.left) :
                find(x,n.right);
    }

    public boolean find(Employee x) {
        if(x==null) return false;
        return find(x,root);
    }
    public void insert(Employee x) {
        Node newNode = new Node(x);
        if(root == null){
            root = newNode;
        }else{
            Node node = root;
            while(true){
                int comp = this.comparator.compare(x,node.element);
                if(comp > 1){
                    if(node.right == null){
                        node.right = newNode;
                        break;
                    }else{
                        node = node.right;
                    }
                } else if(comp < 1){
                    if(node.left == null){
                        node.left = newNode;
                        break;
                    }else{
                        node = node.left;
                    }
                }else{
                    // ignoring the duplicate entry
                    break;
                }
            }
        }
    }

    private void printTree(Node t) {
        if (t != null) {
            printTree(t.left);
            System.out.println(t.element);
            printTree(t.right);
        }
    }

    /**
     * Prints the values in the nodes of the tree in sorted order.
     */
    public void printTree() {
        if (root == null)
            System.out.println("Empty tree");
        else
            printTree(root);
    }

    static class BTreePrinter {

        public static void printNode(Node root) {
            int maxLevel = BTreePrinter.maxLevel(root);

            printNodeInternal(Collections.singletonList(root), 1, maxLevel);
        }

        private static void printNodeInternal(List nodes, int level, int maxLevel) {
            if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
                return;

            int floor = maxLevel - level;
            int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
            int firstSpaces = (int) Math.pow(2, (floor)) - 1;
            int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

            BTreePrinter.printWhitespaces(firstSpaces);

            List newNodes = new ArrayList();
            for (Object node : nodes) {
                if (node != null) {
                    System.out.print(((Node)node).element);
                    newNodes.add(((Node)node).left);
                    newNodes.add(((Node)node).right);
                } else {
                    newNodes.add(null);
                    newNodes.add(null);
                    System.out.print(" ");
                }

                BTreePrinter.printWhitespaces(betweenSpaces);
            }
            System.out.println("");

            for (int i = 1; i <= endgeLines; i++) {
                for (int j = 0; j < nodes.size(); j++) {
                    BTreePrinter.printWhitespaces(firstSpaces - i);
                    if (nodes.get(j) == null) {
                        BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                        continue;
                    }

                    if (((Node)nodes.get(j)).left != null)
                        System.out.print("/");
                    else
                        BTreePrinter.printWhitespaces(1);

                    BTreePrinter.printWhitespaces(i + i - 1);

                    if (((Node)nodes.get(j)).right != null)
                        System.out.print("\\");
                    else
                        BTreePrinter.printWhitespaces(1);

                    BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
                }

                System.out.println("");
            }

            printNodeInternal(newNodes, level + 1, maxLevel);
        }

        static void printWhitespaces(int count) {
            for (int i = 0; i < count; i++)
                System.out.print(" ");
        }

        static int maxLevel(Node node) {
            if (node == null)
                return 0;

            return Math.max(BTreePrinter.maxLevel(node.left), BTreePrinter.maxLevel(node.right)) + 1;
        }

        static boolean isAllElementsNull(List list) {
            for (Object object : list) {
                if (object != null)
                    return false;
            }

            return true;
        }
    }

    public static  void main(String[] args){
        NameComparator nameComp = new NameComparator();

        EmployeeBst bst = new EmployeeBst(nameComp);
        bst.insert(new Employee("George", 40000, 1996,11,5));
        bst.insert(new Employee("Dave", 50000, 2000, 1, 3));
        bst.insert(new Employee("Sally", 45000, 2001, 2, 7));
        bst.insert(new Employee("Richard", 80000, 1986,3,23));
        bst.printTree();

        BTreePrinter.printNode(bst.root);
    }

}
