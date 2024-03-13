package fundamentals.practise.dsa;

public class LinkedList {
    public Node header = null;
    private int size = 0;

    public void addLast(Node n){

        Node last = header;

        if(header == null){
            header = n;
        }else{
            while(last.getNext() != null){
                last = last.getNext();
            }
            last.linkNode(n);
        }

        size++;
    }

    public void addFirst(Node n){
        Node start = header;

        if(header == null){
            header = n;
        }else{
            n.linkNode(start);
            header = n;
        }

        size++;
    }

    public void add(Node n, int pos){
        if(pos < 0 || pos > this.size){
            return;
        }
        if(pos == 0){
             this.addFirst(n);
        }else if(pos == size){
            this.addLast(n);
        }else{
            Node beforePosNode = header;
            for(int i=0;i<pos - 1; i++){
                beforePosNode = header.getNext();
            }
            Node temp = beforePosNode.getNext();
            beforePosNode.linkNode(n);
            n.linkNode(temp);
            size++;
        }
    }


    public static void main(String[] args){
        Node node = new Node();
        node.addData("A");
        System.out.println(node);

        Node nodeb = new Node();
        nodeb.addData("B");
        Node nodec = new Node();
        nodec.addData("C");
        Node noded = new Node();
        noded.addData("D");
        Node nodee = new Node();
        nodee.addData("E");
        nodeb.linkNode(nodec);
        nodec.linkNode(noded);
        noded.linkNode(nodee);

        System.out.println(nodeb);

    }
}
