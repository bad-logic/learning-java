package modernpractises.labs.Lab09.lab09_03;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int countWords(List<String> words,char c, char d, int len){
        return (int) words.stream()
                .filter((x)-> x.length() == len)
                .filter((x)-> x.indexOf(c)!= -1)
                .filter((x)-> x.indexOf(d)==-1)
                .count();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countWords(new ArrayList<>(List.of("abracadabra","Hocus Pocus","Alakajam","Alakazam","Expectro Petronam")),'a','z',8));
    }
}
