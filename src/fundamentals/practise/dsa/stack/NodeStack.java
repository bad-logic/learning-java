package fundamentals.practise.dsa.stack;

public class NodeStack {
    private Node top;
    public void push(String s) {
        Node newN = new Node();
        newN.data = s;
        newN.next = top;
        top = newN;
    }
    public String peek() {
        if(top != null){
            return top.data;
        }else{
            return null;
        }
    }
    public String pop() {
        if(top != null){
            String temp = top.data;
            top = top.next;
            return temp;
        }else{
            return  null;
        }
    }

    public static void main(String[] args) {
        NodeStack stack = new NodeStack();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        System.out.println(stack.peek());
        System.out.println(stack.top.toString());
        System.out.println(stack.pop());
        System.out.println(stack.top.toString());
    }
}
