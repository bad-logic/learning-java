package algorithms.labs.lab04;
import java.util.ArrayList;

public class StackUsingQ {

    private final ArrayList<Integer> q;
//    private final LinkedList<Integer> q;
    StackUsingQ(){
        this.q = new ArrayList<>();
    }

//    StackUsingQ(){
//        this.q = new LinkedList<>();
//    }

    public void push(int x){
        this.q.add(x);
    }

    public int pop(){
        return this.q.removeLast();
    }

    public int top(){
        return this.q.getLast();
    }

    public boolean empty(){
        return this.q.isEmpty();
    }

    public static void main(String[] args){
        StackUsingQ obj = new StackUsingQ();
        obj.push(1);
        obj.push(2);
        System.out.println(obj.top());
        System.out.println(obj.pop());
        System.out.println(obj.empty());
    }
}
