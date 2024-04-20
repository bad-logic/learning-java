package modernpractises.labs.Lab09.lab09_02;


import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Solution {

    public IntStream getIntStream(){
        return IntStream.of(91, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        OptionalInt max = sol.getIntStream().max();
        OptionalInt  min = sol.getIntStream().min();
        if(max.isPresent()){
            System.out.println("max: "+ max.getAsInt());
        }else{
            System.out.println("no max");
        }

        if(min.isPresent()){
            System.out.println("min: "+ min.getAsInt());
        }else{
            System.out.println("no min");
        }
    }
}
