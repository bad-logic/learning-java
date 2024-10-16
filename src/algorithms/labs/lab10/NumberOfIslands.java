package algorithms.labs.lab10;

//Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
//An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
//You may assume all four edges of the grid are all surrounded by water.
//
//Example 1:
//
//Input: grid = [
//        ["1","1","1","1","0"],
//        ["1","1","0","1","0"],
//        ["1","1","0","0","0"],
//        ["0","0","0","0","0"]
//        ]
//Output: 1
//Example 2:
//
//Input: grid = [
//        ["1","1","0","0","0"],
//        ["1","1","0","0","0"],
//        ["0","0","1","0","0"],
//        ["0","0","0","1","1"]
//        ]
//Output: 3


public class NumberOfIslands {
    private static void visit(char[][]grid,boolean[][]visited,int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || visited[i][j]==true || grid[i][j]=='0'){
            return ;
        }
        visited[i][j] = true;
        visit(grid,visited,i-1,j);
        visit(grid,visited,i+1,j);
        visit(grid,visited,i,j-1);
        visit(grid,visited,i,j+1);
    }
    public static int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int islands = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(!visited[i][j] && grid[i][j]=='1'){
                    visit(grid,visited,i,j);
                    islands++;
                }
            }
        }
        return islands;
    }

    public static void main(String[] args){
        char[][] grid = new char[][]{
            new char[]{'1','1','1','1','0'},
            new char[]{'1','1','0','1','0'},
            new char[]{'1','1','0','0','0'},
            new char[]{'0','0','0','0','0'}
        };
        System.out.println(numIslands(grid)); // 1

        grid = new char[][]{
                new char[]{'1','1','0','0','0'},
                new char[]{'1','1','0','0','0'},
                new char[]{'0','0','1','0','0'},
                new char[]{'0','0','0','1','1'}
        };
        System.out.println(numIslands(grid)); // 3
    }
}
