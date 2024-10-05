package algorithms.labs.lab04;

class Q{
    Node head;
    Node tail;
    int size;

    static class Node{
        int value;
        Node prev;
        Node next;
        Node(int val){
            this.value = val;
        }
    }

    Q(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int size(){
        return this.size;
    }

    public void push(int x){
        size++;
        Node node = new Node(x);
        if(tail==null || head==null){
            this.head = node;
            node.prev = this.head;
        }else{
            this.tail.next = node;
            node.prev = this.tail;
        }
        this.tail = node;
    }

    public int peekFirst(){
        if(size<=0) return -1;
        return this.head.value;
    }

    public int peekLast(){
        if(size<=0) return -1;
        return this.tail.value;
    }

    public int pop(){
        if(size<=0) return -1;
        size--;
        Node node = this.head;
        this.head = this.head.next;
        this.head.prev = null;

        node.next = null;
        node.prev = null;
        return node.value;
    }

    public int removeLast(){
        if(size<=0) return -1;
        size--;
        Node node = this.tail;
        this.tail.prev.next = null;
        this.tail = this.tail.prev;
        node.next = null;
        node.prev = null;
        return node.value;
    }
}

class MyStack {
    private final Q queue;

    public MyStack() {
        this.queue = new Q();
    }

    public void push(int x) {
        this.queue.push(x);
    }

    public int pop() {
        return this.queue.removeLast();
    }

    public int top() {
        return this.queue.peekLast();
    }

    public boolean empty() {
        return this.queue.size()==0;
    }
}
