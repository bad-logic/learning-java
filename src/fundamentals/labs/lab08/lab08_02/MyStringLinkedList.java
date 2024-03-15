package fundamentals.labs.lab08.lab08_02;

public class MyStringLinkedList {
    Node header;
    int size = 0;
    MyStringLinkedList(){
        header = new Node(null);
    }
    //adds to the front of the list
    public void addFirst(String item){
        Node n = new Node(item);
        //place new node after header and
        //establish links from new node to
        //surrounding nodes
        n.next = header.next;
        n.previous = header;

        //establish links from surrounding
        //nodes to the new node
        if(header.next != null){
            header.next.previous = n;
        }
        header.next = n;
        size++;
    }

    //adds to the end of the list
    public void addLast(String item) {
        Node n = new Node(item);
        //find last node
        Node last = header;
        while(last.next != null) {
            last = last.next;
        }
        //now last.next == null
        last.next = n;
        n.previous = last;
        size++;
    }

    //removes node in last position
    public void removeLast( ) {
        //if list is empty, return
        if(header.next == null) return;

        Node current = header;
        //traverse the list until current.next is
        //null - then remove current
        while(current.next != null) {
            current = current.next;
        }
        //now current.next == null, so remove current
        Node previous = current.previous;
        //previous is not null since current is not header
        previous.next = null;
        current.previous = null;
        size--;
    }

    void insert(String data, int pos){
        if(pos < 0 || pos > size || header == null) return;

        int counter = 0;
        Node currentPosNode = header.next;
        while(currentPosNode.next != null){
            if(counter == pos){
                break;
            }
            currentPosNode = currentPosNode.next;
            counter++;
        }
        Node newNode = new Node(data);
        newNode.next = currentPosNode;
        newNode.previous = currentPosNode.previous;
        currentPosNode.previous = newNode;
        size++;
    }

    boolean remove(String data){
        if(data == null || header == null) return false;
        Node dataNode = header.next;
        while(dataNode != null){
            if(dataNode.value.equals(data)){
                // remove this node
                Node prevNode = dataNode.previous;
                Node nextNode = dataNode.next;
                prevNode.next = nextNode;
                nextNode.previous = prevNode;
                dataNode.previous = null;
                dataNode.next = null;
                size--;
                return true;
            }
            dataNode = dataNode.next;
        }

        return false;
    }

    private void swap(Node n1, Node n2){
        String temp = n1.value;
        n1.value = n2.value;
        n2.value = temp;
    }
    private Node minNode(Node n){

        Node currentNode = n;
        Node minNode = n;

        while(currentNode != null){
            if(currentNode.value.compareTo(minNode.value) < 0){
                minNode = currentNode;
            }
            currentNode = currentNode.next;
        }

        return minNode;
    }

    void MinSort(){
        if(this.header == null) return;
        Node currentNode = header.next;
        while(currentNode.next != null){
            Node minNode = this.minNode(currentNode);
            swap(currentNode,minNode);
            currentNode = currentNode.next;
        }
    }


    //determines whether the input string is in the list
    public boolean search(String s) {
        Node next = header.next;
        while(next != null && !next.value.equals(s)) {
            next = next.next;
        }
        //either next == null or next.value is s
        if(next == null) return false;
        else {//next.value.equals(s)
            return true;
        }
    }
    public String toString() {
        var sb = new StringBuffer();
        Node next = header.next;
        while(next != null) {
            sb.append(next.toString() + ", ");
            next = next.next;
        }
        var result = sb.toString().trim();
        if(result.length() == 0) return "<empty list>";
        if(result.charAt(result.length()-1) == ',') {
            return result.substring(0,result.length()-1);
        }
        return result;
    }
    class Node {
        String value;
        Node next;
        Node previous;
        Node(String value){
            this.value = value;
        }

        public String toString() {
            return value == null ? "null" : value;
        }
    }

    public static void main(String[] args){
        var list = new MyStringLinkedList();
        list.addLast("Rich");
        System.out.println(list);
        list.removeLast();
        System.out.println(list);
        list.addFirst("Bob");
        list.addFirst("Harry");
        list.addFirst("Steve");
        System.out.println(list);
        list.removeLast();
        System.out.println(list);
        System.out.println(list.search("Harry"));
        System.out.println(list.search("Bob"));
        list.addLast("Tom");
        System.out.println(list);


        // sorting
        System.out.println("#### NEW LIST #######");
        var sl = new MyStringLinkedList();
        sl.addLast("big");
        sl.addLast("small");
        sl.addLast("tall");
        sl.addLast("short");
        sl.addLast("round");
        sl.addLast("square");
        sl.addLast("enormous");
        sl.addLast("tiny");
        sl.addLast("gargantuan");
        sl.addLast("lilliputian");
        sl.addLast("numberless");
        sl.addLast("none");
        sl.addLast("vast");
        sl.addLast("miniscule");
        System.out.println(sl);
        sl.MinSort();
        System.out.println(sl);
    }
}

