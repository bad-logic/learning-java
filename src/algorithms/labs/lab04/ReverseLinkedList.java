package algorithms.labs.lab04;

import java.util.ArrayList;

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        sb.append(this.val).append(", ");
        ListNode node = this.next;
        while(node!=null){
            sb.append(node.val).append(", ");
            node = node.next;
        }
        sb.append(" ]");
        return sb.toString();
    }
}

public class ReverseLinkedList {

         public ListNode reverseListOlder(ListNode head) {
             if(head == null || head.next == null) return head;
             ListNode newHead = head;
             ListNode current = newHead.next;
             newHead.next = null;

             while(true){
                 ListNode next = current.next;
                 current.next = newHead;
                 newHead = current;
                 current = next;
                 if(current == null){
                     break;
                 }
             }

             return newHead;
         }

         public ListNode reverseListRecursion(ListNode head) {
             if(head == null || head.next == null) return head;
             ListNode newHead = reverseList(head.next);
             head.next.next = head;
             head.next = null;
             return newHead;
         }

        public static ListNode reverseList(ListNode head){
            // only one item in the list
            if(head == null || head.next == null) return head;
            ListNode tail = null;
            while(head.next!=null){
                ListNode node = head.next;
                head.next = tail;
                tail = head;
                head = node;
            }
            head.next = tail;
            return head;
        }

        public static void main(String[] args){
             ListNode head = new ListNode(1);
             ListNode node = head;
             int i = 2;
             while(i < 6){
                 ListNode lnode = new ListNode(i);
                 node.next = lnode;
                 node = lnode;
                 i++;
             }
            System.out.println(head);
            System.out.println(reverseList(head));
        }
}
