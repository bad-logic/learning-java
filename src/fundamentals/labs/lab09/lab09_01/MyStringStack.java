package fundamentals.labs.lab09.lab09_01;

public class MyStringStack {
    private MyStringLinkedList list;
    public MyStringStack() {
        list = new MyStringLinkedList();
    }

    public String pop() {
        String v = list.get(0);
        if(list.remove(0)){
            return v;
        };
        return null;
    }
    public String peek() {
        return list.get(0);
    }

    public void push(String s) {
        list.insert(s,0);
    }

    public static void main(String[] args){
        MyStringStack stack = new MyStringStack();
        stack.push("Bob");
        stack.push("Harry");
        stack.push("Alice");
        System.out.println("Popping…"+stack.pop());
        System.out.println("Peeking…."+stack.peek());
        System.out.println("Popping…"+stack.pop());
    }
}
