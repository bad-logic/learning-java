package algorithms.labs.lab07;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {

    public String frequencySort(String s) {
        HashMap<Character,Integer> dict = new HashMap<>();
        for(char c: s.toCharArray()){
            dict.put(c,dict.getOrDefault(c,0)+1);
        }

        PriorityQueue<Map.Entry<Character,Integer>> queue = new PriorityQueue<>((a, b)-> b.getValue()-a.getValue());
        queue.addAll(dict.entrySet());

        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            Map.Entry<Character,Integer> item = queue.poll();
            for(int i=0;i<item.getValue();i++){
                sb.append(item.getKey());
            }
        }
        return sb.toString();
        
    }


}
