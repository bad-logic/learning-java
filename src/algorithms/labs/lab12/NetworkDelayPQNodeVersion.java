package algorithms.labs.lab12;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class NetworkDelayPQNodeVersion {

    static class Node implements Comparable<Node>{
        int weight;
        int node;

        Node(int node,int weight){
            this.weight = weight;
            this.node = node;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight,o.weight);
        }
    }

    public static int networkDelayTime(int[][] times, int n, int k) {
        int[] result = new int[n+1];

        ArrayList<ArrayList<Node>> adjList = new ArrayList<>(n+1);
        // since there is no node 0. reduce indices by 1
        for(int i=0;i<=n;i++){
            adjList.add(i,new ArrayList<>());
        }

        for(int[] arr: times){
            adjList.get(arr[0]).add(new Node(arr[1],arr[2]));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(k,0)); // from k to k it costs 0
        Set<Integer> visited = new HashSet<>();

        while (!pq.isEmpty()){
            Node p = pq.remove();
            if(!visited.contains(p.node)){
                visited.add(p.node);
                result[p.node] = p.weight;

                for(Node node: adjList.get(p.node)){
                    int d =  p.weight + node.weight;
                    pq.add(new Node(node.node,d));
                }

            }
        }

        if(visited.size() != n) return -1;

        int max = Integer.MIN_VALUE;
        for(int ar: result){
            if(ar > max){
                max = ar;
            }
        }

        return max;
    }

    public static void main(String[] args){
        System.out.println("\n answer: " + networkDelayTime(new int[][]{new int[]{2,1,1},new int[]{2,3,1},new int[]{3,4,1}},4,2));// 2
        System.out.println("\n answer: " + networkDelayTime(new int[][]{new int[]{1,2,1}},2,2));// -1
        System.out.println("\n answer: " + networkDelayTime(new int[][]{new int[]{1,2,1}},2,1));// 1
    }
}
