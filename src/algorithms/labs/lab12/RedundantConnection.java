package algorithms.labs.lab12;


//In this problem, a tree is an undirected graph that is connected and has no cycles.
//
//You are given a graph that started as a tree with n nodes labeled from 1 to n, with one
//additional edge added. The added edge has two different vertices chosen from 1 to n, and
//was not an edge that already existed. The graph is represented as an array edges of length n
//where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the graph.
//
//Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are
//multiple answers, return the answer that occurs last in the input.
//
//Example 1:
//Input: edges = [[1,2],[1,3],[2,3]]
//Output: [2,3]
//
//Example 2:
//Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
//Output: [1,4]

import java.util.*;

public class RedundantConnection {

    static class UnionFind {
        private final int[] parent;
        private final int[] rank;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i; // initially each node is its own parent
//            rank[i] = 0; // every elements rank is 0 at the beginning
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                // Path compression step: make all nodes point directly to the root
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        // Union two sets containing 'x' and 'y' (by rank)
        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                int comp = Integer.compare(this.rank[rootX], this.rank[rootY]);
                switch (comp) {
                    case -1 -> this.parent[rootX] = rootY;
                    case 0 -> {
                        this.parent[rootX] = rootY;
                        this.rank[rootY]++;
                    }
                    case 1 -> this.parent[rootY] = rootX;
                }
                return true;
            }
            // already same parent
            return false;
        }
    }

    public static int[] findRedundantConnection(int[][] edges) {
        UnionFind un = new UnionFind(edges.length+1);
       for(int[] edge: edges){
           if(!un.union(edge[0],edge[1])){
               return edge;
           }
       }
       // guaranteed to have a redundant edge so it below
        // will not execute
        return new int[]{};
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(findRedundantConnection(new int[][]{new int[]{1,2}, new int[]{1,3}, new int[]{2,3}}))); // [2,3]
    }
}
