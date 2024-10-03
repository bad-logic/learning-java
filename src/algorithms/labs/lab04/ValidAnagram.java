package algorithms.labs.lab04;

import java.util.HashMap;

public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        HashMap<Character,Integer> map =  new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }else{
                map.put(s.charAt(i),1);
            }
        }

        for(int i=0;i<t.length();i++){
            Integer count = map.get(t.charAt(i));
            if(count==null) return false;
            if(count>1){
                map.put(t.charAt(i),count-1);
            }else{
                map.remove(t.charAt(i));
            }
        }
        return true;

    }

    public static void main(String[] args){
        System.out.println(isAnagram("anagram","nagaram"));
    }
}
