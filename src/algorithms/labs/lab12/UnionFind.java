package algorithms.labs.lab12;

import java.util.Arrays;

public class UnionFind {
    private final int[] parent;
    private final int[] rank;

    public UnionFind(int n){
        this.parent = new int[n];
        this.rank = new int[n];

        for(int i=0;i<n;i++){
            parent[i] = i; // initially each node is its own parent
//            rank[i] = 0; // every elements rank is 0 at the beginning
        }
    }

    public int find(int x){
        if(parent[x] != x){
            // Path compression step: make all nodes point directly to the root
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // Union two sets containing 'x' and 'y' (by rank)
    public boolean union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);

        if(rootX != rootY){
            int comp = Integer.compare(this.rank[rootX],this.rank[rootY]);
            switch (comp){
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

    @Override
    public String toString() {
        return "UnionFind{" +
                "parent=" + Arrays.toString(parent) +
                ", rank=" + Arrays.toString(rank) +
                '}';
    }

}
