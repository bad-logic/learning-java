package fundamentals.practise.dsa.queue;

public class MyQueue {
    private class Node{
        Integer data;
        Node previous,next;
    }
    private Node front, rear;
    public void enqueue(Integer e){
        Node newNode = new Node();
        newNode.data = e;
        newNode.next = null;
        if(front == null){
            this.front = newNode;
            newNode.previous = null;
        }else{
            this.rear.next = newNode;
            newNode.previous = this.rear;
        }
        this.rear = newNode;
    }

    public Integer dequeue() throws Exception {
        if(this.front == null){
            throw new Exception("cannot dequeue: Queue is empty");
        }
        Node prevFront = this.front;
        this.front = front.next;
        this.front.previous = null;
        return prevFront.data;
    }

    public Integer peek() throws Exception  {
        if(this.front == null){
            throw new Exception("cannot peek: Queue is empty");
        }
        return this.front.data;
    }

    public String toString(){
        String output = "[ ";
        Node front = this.front;

        while(front != null){
            String prev = front.previous != null ? front.previous.data.toString() : "null";
            String next = front.next !=null ? front.next.data.toString() :"null";
            output += "Node { " + prev + " <- " + front.data + " -> " + next + " }, ";
            front = front.next;
        }
        output += "]";
        return output;
    }

    public static void main(String[] args){
        MyQueue mq = new MyQueue();
        mq.enqueue(45);
        mq.enqueue(55);
        mq.enqueue(88);
        mq.enqueue(99);
        System.out.println(mq);

        try{
            System.out.println("Peeking: " + mq.peek());
            System.out.println("Dequeuing: " + mq.dequeue());
            System.out.println(mq);
            System.out.println("Dequeuing: " + mq.dequeue());
            System.out.println(mq);
            System.out.println("Dequeuing: " + mq.dequeue());
            System.out.println(mq);
            System.out.println("Peeking: " + mq.peek());

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
