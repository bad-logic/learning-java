package fundamentals.practise.dsa.arrays;

import java.util.HashSet;

public class Sudoko {


    public static boolean isRowValid(int[][] arr, int row){
        HashSet<Integer> st = new HashSet<>();
        for(int value : arr[row]){
            if(value < 0 || value > 9 || st.contains(value) ) return false;
            st.add(value);
        }
        return true;
    }

    public static boolean isColValid(int[][] arr, int col){
        HashSet<Integer> st = new HashSet<>();
        for (int[] row : arr) {
            if (row[col] < 0 || row[col] > 9 || st.contains(row[col])) return false;
            st.add(row[col]);
        }
        return true;
    }

    public static boolean isSubGridValid(int[][] arr, int row, int col){
        HashSet<Integer> st = new HashSet<>();
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                int value = arr[row+i][col+j];
                if(value < 0 || value > 9 || st.contains(value) ) return false;
                st.add(value);
            }
        }
        return true;
    }

    public static boolean isSudokoBoardValid(int[][] board){
        for(int i=0;i<board.length;i++){
            if(!isRowValid(board,i)) return false;
        }

        for(int i=0;i<board[0].length;i++){
            if(!isColValid(board,i)) return false;
        }

        for(int i=0;i<board.length;i=i+3){
            for(int j=0;j<board.length;j=j+3){
                if(!isSubGridValid(board,i,j)) return false;
            }
        }


        return true;
    }

    public static void main(String[] args){
        System.out.println(isSudokoBoardValid(new int[][] {
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        }));
    }
}
