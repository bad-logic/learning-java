package fundamentals.practise.dsa;

public class SinglyLinkedList {
    private Node header;

    private class Node{
        private Integer data;
        private Node next;
    }

    public void addFirst(Integer e){
        Node newNode = new Node();
        newNode.data = e;
        if(header == null){
            header = newNode;
            return;
        }
        newNode.next = header;
        header = newNode;
    }

    public void addLast(Integer e){
        Node newNode = new Node();
        newNode.data = e;
        if(header == null){
            header = newNode;
            return;
        }

        Node node = header;
        while(node.next != null){
            node = node.next;
        }
        node.next = newNode;
    }

    public boolean remove(int index){
        Node previousNode = header;
        int counter = 0;
        while(previousNode.next != null){
            if(counter == index-1){
                break;
            }
            previousNode = previousNode.next;
            counter++;
        }

        // remove
        Node deleteNode = previousNode.next;
        if(deleteNode == null) return false;
        previousNode.next = deleteNode.next;
        return true;
    }

//    private String print(Node n){
//        if(n == null) return "";
//        StringBuilder sb = new StringBuilder("");
//        sb.append(n.data);
//        sb.append(" ");
//        sb.append(print(n.next));
//        return sb.toString();
//    }

    private String print(Node n){
        if(n == null) return "";
        String output = "";
        output += n.data + " " +this.print(n.next);
        return output;
    }

    public void print(){
        System.out.println(this.print(this.header));
    }

    public static void main(String[] args){
        SinglyLinkedList sl = new SinglyLinkedList();
        System.out.println("Adding 5 at last");
        sl.addLast(5);
        sl.print();
        System.out.println("Adding 6 at last");
        sl.addLast(6);
        sl.print();
        System.out.println("Adding 56 at first");
        sl.addFirst(56);
        sl.print();
        System.out.println("Adding 99 at first");
        sl.addFirst(99);
        sl.print();
        System.out.println("Adding 45 at first");
        sl.addFirst(45);
        sl.print();
        System.out.println("Removing 3rd index");
        sl.remove(3);
        sl.print();
    }

}
