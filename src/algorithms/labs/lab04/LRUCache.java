package algorithms.labs.lab04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Node{
    int key;
    int value;
    Node next;
    Node prev;
    Node(int k, int v){
        this.key = k;
        this.value = v;
    }

    public String toString(){
        StringBuilder sbr = new StringBuilder();
        sbr.append("Node( ");
        sbr.append(this.key);
        sbr.append(", ");
        sbr.append(this.value);
        sbr.append(", ");
        if(this.prev!= null){
            sbr.append("Prev: Node( ");
            sbr.append(this.prev.key);
            sbr.append(", ");
            sbr.append(this.prev.value);
            sbr.append(" ), ");
        }
        if(this.next!= null){
            sbr.append("Next: Node( ");
            sbr.append(this.next.key);
            sbr.append(", ");
            sbr.append(this.next.value);
            sbr.append(" ) ");
        }
        sbr.append(" )");
        return sbr.toString();
    }

    public void print(){
        Node node = this;
        StringBuilder bdr = new StringBuilder();
        bdr.append("{");
        while(node!=null){
            bdr.append("Node( ");
            bdr.append(node.key);
            bdr.append(", ");
            bdr.append(node.value);
            bdr.append(" )->");
            node = node.next;
        }
        bdr.append("null }");
        System.out.println(bdr.toString());
    }
}

class LRUCache {
    private final int capacity;
    private final HashMap<Integer, Node> dict = new HashMap<>();
    private final Node head; // contains least used
    private Node tail; // contains recently used

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(-1,-1);
        this.tail = null;
    }

    public void addPrioritizedNode(Node node){
        if(this.tail == null){
            head.next = node;
            node.prev = head;
        }else{
            this.tail.next = node;
            node.prev = this.tail;
        }
        this.tail = node;
    }

    public void removeNode(Node node){
        Node prev = node.prev;
        Node next = node.next;
        node.prev = null;
        node.next = null;
        if(next!=null){
            next.prev = prev;
        }
        if(prev!=null){
            prev.next = next;
        }
    }

    public int get(int key) {
        System.out.print("Fetching for key "+ key+": ");
        Node node = this.dict.get(key);
        if(node == null) return -1;
        // if this node is tail node, its priority is correct
        if(tail!=node){
            removeNode(node);
            addPrioritizedNode(node);
        }
        return node.value;
    }

    public void put(int key, int value) {
        System.out.print("key: " + key +", value: " + value);
        Node node = this.dict.get(key);

        if (node != null) {
            System.out.print(", found: true, ");
            if(tail==node){
                // already most recently used, just update the value
                node.value = value;
                return;
            }
            removeNode(node);
        }
        node = new Node(key, value);
        this.dict.put(key, node);
        addPrioritizedNode(node);
        System.out.print(", capacity: " + this.capacity);
        System.out.println(", size: " + this.dict.size());
        System.out.print("head: ");
        head.print();
        System.out.print("tail: ");
        tail.print();
//        System.out.println(", dictionary: " + this.dict);
        if (this.dict.size() > this.capacity) {
            int deleteKey = this.head.next.key;
            Node deleteNode = this.dict.get(deleteKey);
            System.out.println("Delete: " + deleteKey);
            removeNode(deleteNode);
            this.dict.remove(deleteKey);
        }

    }

    public static void main(String[] args){
        LRUCache obj = new LRUCache(10);
//        obj.put(2,1);
//        obj.put(3,2);
//        System.out.println(obj.get(3));
//        System.out.println(obj.get(2));
//        obj.put(4,3);
//        System.out.println(obj.get(2));
//        System.out.println(obj.get(3));
//        System.out.println(obj.get(4));

        List<String> arr1 = List.of("10,13","3,17","6,11","10,5","9,10","13","2,19","2","3","5,25","8","9,22","5,5","1,30","11","9,12","7","5","8","9","4,30","9,3","9","10","10","6,14","3,1","3","10,11","8","2,14","1","5","4","11,4","12,24","5,18","13","7,23","8","12","3,27","2,12","5","2,9","13,4","8,18","1,7","6","9,29","8,21","5","6,30","1,12","10","4,15","7,22","11,26","8,17","9,29","5","3,4","11,30","12","4,29","3","9","6","3,4","1","10","3,29","10,28","1,20","11,13","3","3,12","3,8","10,9","3,26","8","7","5","13,17","2,27","11,15","12","9,19","2,15","3,16","1","12,17","9,1","6,19","4","5","5","8,1","11,7","5,2","9,28","1","2,2","7,4","4,22","7,24","9,26","13,28","11,26");
//        if(arr.size() == arr1.size()){
//            throw new Error("size are not equal");
//        }
        for(int i=0;i<arr1.size();i++){
            String[] temp = arr1.get(i).split(",");
            if(temp.length == 2){
                obj.put(Integer.parseInt(temp[0]),Integer.parseInt(temp[1]));
            }
            if(temp.length == 1){
                System.out.println(obj.get(Integer.parseInt(temp[0])));
            }

        }
    }
}

