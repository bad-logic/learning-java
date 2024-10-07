package algorithms.labs.lab05;

import java.util.ArrayList;
import java.util.List;

public class BSTSort {
    static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
        Node(int val, Node left, Node right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    Node root;


    BSTSort(int[]  arr){
        root = new Node(arr[0]);
        for(int i=1;i<arr.length;i++){
            insert(root,arr[i]);
        }
    }

    private void insert(Node node, int a){
        if( a > node.val){
            if(node.right != null){
                insert(node.right,a);
            }else{
                node.right = new Node(a);
            }
        }else{
            if(node.left!=null){
                insert(node.left,a);
            }else{
                node.left = new Node(a);
            }
        }
    }

    private List<Integer> inorderTraversal(Node node, List<Integer> list){
        if(node == null) return list;

        inorderTraversal(node.left,list);
        list.add(node.val);
        inorderTraversal(node.right,list);

        return list;
    }

    public List<Integer> sort(){
        return this.inorderTraversal(root,new ArrayList<>());
    }

    public static void main(String[] args){
        System.out.println(new BSTSort(new int[]{4,3,78,55,99,0,12,3,5}).sort());
        System.out.println(new BSTSort(new int[]{77,78,99,1001,2003,45,67,89,0,1,45,33,56,78,99,10001,12345,67,32,22,11,76,89,96,108,120,2000,2001,2020,0,45,66,78,56}).sort());
    }
}
