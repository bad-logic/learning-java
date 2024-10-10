package algorithms.labs.lab08;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
    static String[] dict = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    private static  List<String> letterCombinations(List<String> result, StringBuilder temp, String digits){
        if(digits.isEmpty()){
            result.add(temp.toString());
            return result;
        }
        String keypadValues = dict[Integer.parseInt(String.valueOf(digits.charAt(0)))];
        for(char c: keypadValues.toCharArray()){
            temp.append(c);
            letterCombinations(result,temp,digits.substring(1));
            temp.setLength(temp.length()-1);
        }
        return result;
    }


    public static List<String> letterCombinations(String digits) {
        if(digits.isBlank()) return new ArrayList<>();
        return letterCombinations(new ArrayList<String>(), new StringBuilder(), digits);
    }

    public static void main(String[] args){
        System.out.println(letterCombinations("23"));
    }
}
