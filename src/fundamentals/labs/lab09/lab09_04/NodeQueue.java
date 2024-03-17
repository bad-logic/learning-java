package fundamentals.labs.lab09.lab09_04;

public class NodeQueue {
    /* stores the element at the front of the queue, if it exists */
    private Node head;

    /* stores the element at the end of the queue, if it exists */
    private Node tail;

    /**
     * Inserts a new node containing s at end of queue
     */
    public void enqueue(String s) {
        Node newNode = new Node();
        newNode.data = s;
        newNode.next = null;

        if(this.head == null){
            // first insertion
            this.head = newNode;
        }else{
            this.tail.next = newNode;
        }
        this.tail = newNode;
    }
    /**
     * Removes node from the front of the queue and returns its value if
     * head is n
     */
    public String dequeue() throws QueueException {
        if(isEmpty()) throw new QueueException("Queue is empty!");
        Node currentHead = this.head;
        this.head = currentHead.next;
        return currentHead.data;
    }
    /**
     * Returns value stored at the front of the queue
     * @return
     * @throws QueueException
     */
    public String peek() throws QueueException {
        if(isEmpty()) throw new QueueException("Queue is empty!");
        return this.head.data;
    }
    public boolean isEmpty() {
        return this.head == null;
    }
    @Override
    public String toString() {
        if(isEmpty()) return "<empty queue>";
        return this.head.toString();
    }
}



