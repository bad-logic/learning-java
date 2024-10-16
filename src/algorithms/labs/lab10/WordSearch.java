package algorithms.labs.lab10;

//Given an m x n grid of characters board and a string word, return true if word exists in the grid.
//The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally
//or vertically neighboring. The same letter cell may not be used more than once.
//
//Example:
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
//Output: true
//
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
//Output: true
//
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
//Output: false


/**
 *
 * Time complexity: O(m*n*m*n) => O((m*n)^2); m*n -> items in the board
 * Space Complexity: O(len of the word)
 *
 */
public class WordSearch {
    private static boolean backtrack(char[][] board, String word, int i,int j, int strIndex){
        if(strIndex >= word.length()) return true;

        if(i<0||j<0||i>=board.length||j>=board[i].length){
            return false;
        }
        if(board[i][j]!=word.charAt(strIndex)){
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '*';
        if(
            backtrack(board,word,i+1,j,strIndex+1)||
            backtrack(board,word,i-1,j,strIndex+1)||
            backtrack(board,word,i,j+1,strIndex+1)||
            backtrack(board,word,i,j-1,strIndex+1)
        ){
            return true;
        };

        board[i][j] = temp;
        return false;
    }

    public static boolean exist(char[][] board, String word) {

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(backtrack(board,word,i,j,0)){
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args){
        char[][] board = new char[][]{
                new char[]{'A','B','C','E'},
                new char[]{'S','F','C','S'},
                new char[]{'A','D','E','E'},
        };
        System.out.println(exist(board,"ABCCED")); // true

        board = new char[][]{
                new char[]{'A','B','C','E'},
                new char[]{'S','F','C','S'},
                new char[]{'A','D','E','E'}
        };
        System.out.println(exist(board,"ABCB")); // false

        board = new char[][]{
                new char[]{'A','B','C','E'},
                new char[]{'S','F','C','S'},
                new char[]{'A','D','E','E'}
        };
        System.out.println(exist(board,"SEE")); // true

        board = new char[][]{
                new char[]{'a','b'},
        };
        System.out.println(exist(board,"ba")); // true

        board = new char[][]{
                new char[]{'A','B','C','E'},
                new char[]{'S','F','C','S'},
                new char[]{'A','D','E','E'}
        };
        System.out.println(exist(board,"ABCB")); // false

        board = new char[][]{
                new char[]{'a','b'},
                new char[]{'c','d'},
        };
        System.out.println(exist(board,"cdba")); // true
    }
}
