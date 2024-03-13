package fundamentals.practise.dsa;

public class Node {
    private String data;
    private Node next;

    void linkNode(Node n){
        this.next = n;
    }

    void addData(String d){
        this.data = d;
    }

    String getData(){
        return this.data;
    }

    Node getNext(){
        return this.next;
    }

    public String toString(){
        String output = "|"+ this.data+"|";
        if(this.next != null){
            output += "-->" + this.next.toString();
        }
        return output;
    }

}
