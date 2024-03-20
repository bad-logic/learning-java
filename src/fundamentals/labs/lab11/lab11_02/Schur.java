package fundamentals.labs.lab11.lab11_02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Schur {
    static boolean checkForSum(List<Integer> list, Integer z){
        HashMap<Integer,Integer> map = new HashMap<>();

        for(Integer num: list){
            Integer nextNumToEqualSum = z - num;
            if(map.containsKey(nextNumToEqualSum)){
                return true;
            }
            map.put(num,num);
        }

        return false;
    }

    public static void main(String[] args){
        List<Integer> numbers = Arrays.asList(2, 4, 7, 11, 15);
        System.out.println(checkForSum(numbers, 11));
        System.out.println(checkForSum(numbers, 12));
        System.out.println(checkForSum(numbers, 17));
    }
}
