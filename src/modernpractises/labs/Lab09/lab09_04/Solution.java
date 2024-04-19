package modernpractises.labs.Lab09.lab09_04;

import java.util.stream.Stream;

public class Solution {
    public static void printSquares(int num){
        Stream.iterate(1,x -> x+1)
                .limit(num)
                .map(x->x*x)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        Solution.printSquares(4);
    }
}
