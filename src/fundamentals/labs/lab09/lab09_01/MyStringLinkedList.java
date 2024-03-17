package fundamentals.labs.lab09.lab09_01;

public class MyStringLinkedList {
    Node header;
    MyStringLinkedList(){
        header = new Node(null,null, null);
    }
    public Node add(String item){
        Node n = new Node(header.next,header,item);
        if(header.next != null){
            header.next.previous = n;
        }
        header.next = n;
        return n;
    }
    private Node getNode(int pos){
        if (pos >= size()) throw new IndexOutOfBoundsException();
        Node next = header;
        for(int i = 0; i <= pos; ++i){
            next = next.next;
        }
        //next is the node we are seeking
        return next;
    }

    public String get(int pos){
        Node node = getNode(pos);
        return (node != null) ? node.value : null;
    }
    /** returns the index of the String s, if found;
     * -1 otherwise
     */
    public int find(String s){
        if(s == null) return -1;
        Node currentNode = header;
        int i = -1;
        while(currentNode.next != null){
            ++i;
            currentNode = currentNode.next;
            if(s.equals(currentNode.value)) return i;
        }
        return -1;
    }


    public void insert(String s, int pos) {
        //corrected to throw exception
        if(pos > size()) {
            throw new IndexOutOfBoundsException("pos = "+pos +" but size = "+size());
        }
        Node next = header;
        Node previous = null;
        for(int i = 0; i <= pos; ++i){
            if(i==pos){
                previous = next;
            }
            next = next.next;
        }
        Node insertNode = new Node(next,previous,s);
        if(next != null){
            next.previous = insertNode;
        }
        previous.next =insertNode;
    }

    /** remove object at specified index */
    public boolean remove(int index){
        Node toBeRemoved = getNode(index);
        if(toBeRemoved == null) return false;
        Node previous = toBeRemoved.previous;
        Node next = toBeRemoved.next;
        previous.next = toBeRemoved.next;
        if(next != null){
            next.previous = toBeRemoved.previous;
        }
        toBeRemoved = null;
        return true;
    }

    /** remove by specifying object -- removes
     *  first occurrence of s
     */
    public boolean remove(String s){
        int pos = find(s);
        if(pos == -1) return false;
        return remove(pos);
    }

    public int size(){
        int count = 0;
        Node next = header.next;
        while(next != null){
            ++count;
            next = next.next;
        }
        return count;
    }

    public String toString(){
        Node next = header.next;
        String output = next.toString();

        return ("[" + output +"]");
    }

    /******* sorting methods ********/

    private void swap(Node s, Node t){
        String temp = s.value;
        s.value = t.value;
        t.value = temp;
    }

    public void sort(){
        int size = size();
        if(size<=1) return;
        Node curr = header;
        while(curr.next != null){
            curr = curr.next;
            Node min = minNode(curr);
            //this places the min val in curr,
            //so we do not need to reset value of curr here
            swap(min,curr);

        }

    }

    //find the Node having min value nested inside theNode
    public Node minNode(Node theNode){
        if(theNode == null || theNode.next == null) return theNode;
        String minVal = theNode.value;
        Node minNode = theNode;
        Node currentNode = theNode;
        while(currentNode.next != null){
            currentNode = currentNode.next;
            if(currentNode.value.compareTo(minVal)<0) {
                minVal = currentNode.value;
                minNode = currentNode;
            }
        }
        return minNode;
    }

    /********* end sorting methods ********/

    /******** binary search methods ********/

    //search a sorted array
    //Note: because locating the middle value in
    //the list takes linear time each time it's performed,
    //binary search for linked lists is no more efficient
    //than the usual find method
    boolean binSearch(String val) {
        boolean b = recurse(0,size()-1, val);
        return b;
    }


    boolean recurse(int a, int b, String val) {
        int mid = (a+b)/2;
        if(get(mid).equals(val)) return true;
        if(a > b) return false;
        if(val.compareTo(get(mid))>0)
            return recurse(mid+1, b, val);
        return recurse(a,mid-1,val);
    }

    /********* end binary search methods *****/

    class Node  {
        String value;
        Node next;
        Node previous;
        Node(){}
        Node(Node next, Node previous, String value){
            this.next = next;
            this.previous = previous;
            this.value = value;
        }
        @Override
        public String toString() {
            if(value == null) return "";
            StringBuilder sb = new StringBuilder(value + " ");
            sb = toString(sb, next);
            return sb.toString();
        }
        private StringBuilder toString(StringBuilder sb, Node n) {
            if(n == null) return sb;
            sb.append(n.value + " ");
            return toString(sb, n.next);
        }
    }

    public static void main(String[]args){
        MyStringLinkedList l = new MyStringLinkedList();

        l.add("Jim");
        l.add("Jim");
        l.add("Dave");
        l.add("Jim");
        l.add("Ricardo");
        System.out.println(l);
        System.out.println(l.size());
        l.sort();

        if(l.size() > 0){
            System.out.println(l);
        }
        else{
            System.out.println("empty");
        }

        l.insert("Bob", 0);
        l.insert("Dave", 1);
        l.insert("Jim", 2);
        l.add("Ricardo");
        System.out.println(l);
        l.sort();
        System.out.println(l);

        System.out.println("Size = " + l.size());
        System.out.println("The list = " + l);
        l.insert("Sally", 2);
        l.insert("Billy", 0);
        System.out.println("Size = " + l.size());
        System.out.println("The list = " + l);
        l.sort();
        System.out.println("The list = " + l);
        System.out.println("Found Bob "+l.find("Bob"));
        System.out.println("Found Bobby " + l.find("Bobby"));
        l.remove("Sally");
        System.out.println(l);
        l.remove(0);
        System.out.println(l);
        System.out.println("List contains Sally? " + l.binSearch("Sally"));
        System.out.println("List contains Bob? " + l.binSearch("Bob"));


    }

}



