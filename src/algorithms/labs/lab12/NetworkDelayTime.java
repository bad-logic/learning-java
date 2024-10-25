package algorithms.labs.lab12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel
//times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node,
//and wi is the time it takes for a signal to travel from source to target.
//
//We will send a signal from a given node k. Return the minimum time it takes for all the n nodes
//to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.
//Example 1:
//Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
//Output: 2
//
//Example 2:
//Input: times = [[1,2,1]], n = 2, k = 1
//Output: 1
//
//Example 3:
//Input: times = [[1,2,1]], n = 2, k = 2
//Output: -1

//Constraints:
//
// 1 <= k <= n <= 100
// 1 <= times.length <= 6000
//times[i].length == 3
//        1 <= ui, vi <= n
//ui != vi
//0 <= wi <= 100
//All the pairs (ui, vi) are unique. (i.e., no multiple edges.)

public class NetworkDelayTime {
    private static int[][] getPaths(int[][] edges, Set<Integer> visited){
        int[][] paths = new int[edges.length][3];
        int count = 0;
        for(int[] edge:edges){
            if(visited.contains(edge[1])) continue;
            if(visited.contains(edge[0])){
                paths[count] = edge;
                count++;
            }
        }
        return Arrays.copyOf(paths,count);
    }


    // using dijkstra shortest path algorithm
    public static int networkDelayTime(int[][] times, int n, int k) {
        int[] result = new int[n];
        Arrays.fill(result,-1);

        System.out.println("given edges with time: "+Arrays.deepToString(times));
        System.out.println("Result: "+ Arrays.toString(result));

        Set<Integer> nodes = new HashSet<>();
        for(int i=0;i<n;i++){
            nodes.add(i+1);
        }

        System.out.println("nodes: "+ nodes);

        Set<Integer> visited = new HashSet<>();
        visited.add(k); // k being the first or starting node
        result[k-1] = 0; // sending signal from k to k cost 0;

        while(!visited.equals(nodes)){
            System.out.println("visited: "+ visited);
            System.out.println("Result: "+Arrays.toString(result));
            int[][] pool = getPaths(times,visited);
            System.out.println("pool"+ Arrays.deepToString(pool));

            if(pool.length == 0){
                // cannot reach all nodes
                return -1;
            }

            int min = Integer.MAX_VALUE;
            int[] edge = new int[3];

            for(int[] ar:pool){
                System.out.println("arr pool: "+ Arrays.toString(ar));
                int d =  result[ar[0]-1] + ar[2];
                System.out.println("minD: "+ d);
                if(d < min){
                    edge = new int[]{k,ar[1],d};
                    min = d;
                }
            }
            System.out.println("edge: " + Arrays.toString(edge));
            result[edge[1]-1] = edge[2];
            visited.add(edge[1]);
        }

//        System.out.println(Arrays.toString(result));

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
