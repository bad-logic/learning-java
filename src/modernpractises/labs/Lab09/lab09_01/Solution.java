package modernpractises.labs.Lab09.lab09_01;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    public static void main(String[] args){
       String out = Stream.of("Bill","Thomas", "Mary").collect(Collectors.joining(", "));
       System.out.println(out);
    }
}
