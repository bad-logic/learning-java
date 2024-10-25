package algorithms.labs.lab12;


//You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].
//
//The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|,
//where |val| denotes the absolute value of val.
//
//Return the minimum cost to make all points connected. All points are connected if there
//is exactly one simple path between any two points.

//Example 1:
//Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
//Output: 20
//Explanation:
//We can connect the points as shown above to get the minimum cost of 20.
//Notice that there is a unique path between every pair of points.
//
//Example 2:
//Input: points = [[3,12],[-2,5],[-4,1]]
//Output: 18

import java.util.Arrays;

public class MinCostToConnectAllPoints {
    static class UnionFind {
        private final int[] parent;
        private final int[] rank;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i; // initially each node is its own parent
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

    public static int minCostConnectPoints(int[][] points) {
        int[][] paths = new int[points.length*points.length][3];
        int cursor = 0;
        for(int i=0;i<points.length;i++){
            for (int j=i+1;j<points.length;j++){
                int dist = Math.abs(Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1]));
//                System.out.println("i: " + i + ", j: " + j + ", cursor: " + cursor);
                paths[cursor++] = new int[]{dist,i,j};
            }
        }
        Arrays.sort(paths,(a, b)->a[0]-b[0]);
//        System.out.println(Arrays.deepToString(paths));
        int result = 0;
        UnionFind uf = new UnionFind(paths.length);
        for(int[] arr: paths){
            if(arr[0]==0&&arr[1]==0&&arr[2]==0) continue;
            if(uf.union(arr[1],arr[2])){
                result += arr[0];
            }
        }

        return result;

    }

    public static void main(String[] args){
        System.out.println(minCostConnectPoints(new int[][]{new int[]{7,18},new int[]{-15,19},new int[]{-18,-15},new int[]{-7,14},new int[]{4,1},new int[]{-6,3}}));// 85
    }
}
