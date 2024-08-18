package fundamentals.practise.dsa.arrays;


/**
 *
 * given an odd number n produces n*n matrix
 * where each row, columns and diagonal
 * have equal sum value
 *
 * steps:
 * start adding numbers from 1 to n*n in ascending order in the array or matrix
 * add 1 to the middle of the bottom row
 * move 1 step right and 1 step down to add the another number
 * if that spot has 0, or nothing place the next number
 * if you move out of the boundary, use wrap-around
 * if the spot already has some value move 1 row up to place the value, just above the current spot
 *
 */

public class MagicSquares {

    public static int[][] computeMagicSquares(int n) {
       int[][] magicSquares = new int[n][n];

        // in order to compute magicSquare order must be odd
        if((n & 1) == 0 ){
            return magicSquares;
        }

        // insert 1 to the middle element of the last row
        magicSquares[n-1][n / 2] = 1;
        int row = n - 1;
        int col = n / 2;
        for(int i=2;i<=n*n;i++){
            // for very next number move +1 row and +1 column
            // if that spot has 0, place the number in the spot
            // if outside the matrix or array use wrap around
            if(magicSquares[(row+1) % n][(col+1) % n] == 0){
                row = (row+1) % n;
                col = (col+1) % n;
            }else{
                // if spot doesnot have 0 move -1 row
                row = row - 1;
            }
            magicSquares[row][col] = i;
        }
        return magicSquares;
    }

    public static void print2DArray(int[][] arr){
        StringBuilder message = new StringBuilder();
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(j==0){
                    message.append(String.format("|%3s",arr[i][j]));
                } else if (j==arr[0].length-1) {
                    message.append(String.format("%3s%2s|\n",arr[i][j],""));
                }else{
                    message.append(String.format("%3s",arr[i][j]));
                }
            }
        }
        System.out.println(message);
    }


    public static void main(String[] args){
        print2DArray(computeMagicSquares(3));
        print2DArray(computeMagicSquares(5));
        print2DArray(computeMagicSquares(9));
    }
}
