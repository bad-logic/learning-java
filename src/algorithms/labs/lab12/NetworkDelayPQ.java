package algorithms.labs.lab12;

import java.util.*;

public class NetworkDelayPQ {

    static class Node{
        int node;
        int weight;

        Node(int n,int w){
            this.weight = w;
            this.node = n;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "node=" + node +
                    ", weight=" + weight +
                    '}';
        }
    }

    public static int networkDelayTime(int[][] times,int n,int k){
        int[] result = new int[n+1];
        HashMap<Integer, List<Node>> adjList = new HashMap<>();

        for(int[] arr: times){
            Node nd = new Node(arr[1],arr[2]);
            List<Node> ls = adjList.getOrDefault(arr[0], new ArrayList<>());
            ls.add(nd);
            adjList.put(arr[0],ls);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{k,0}); // from k to k it costs 0
        Set<Integer> visited = new HashSet<>();

//        System.out.println(adjList);

        while (!pq.isEmpty()){
            int[] p = pq.remove();
            if(!visited.contains(p[0])){
                visited.add(p[0]);
                result[p[0]] = p[1];
                if(!adjList.containsKey(p[0])) continue;
                for(Node node: adjList.get(p[0])){
                    int d =  p[1] + node.weight;
                    pq.add(new int[]{node.node,d});
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
