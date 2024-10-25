package algorithms.labs.lab09;

import java.util.Arrays;
import java.util.HashMap;

//Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
//You have the following three operations permitted on a word:
//Insert a character
//Delete a character
//Replace a character
//
//Example 1:
//
//Input: word1 = "horse", word2 = "ros"
//Output: 3
//Explanation:
//horse -> rorse (replace 'h' with 'r')
//rorse -> rose (remove 'r')
//rose -> ros (remove 'e')
//Example 2:
//
//Input: word1 = "intention", word2 = "execution"
//Output: 5
//Explanation:
//intention -> inention (remove 't')
//inention -> enention (replace 'i' with 'e')
//enention -> exention (replace 'n' with 'x')
//exention -> exection (replace 'n' with 'c')
//exection -> execution (insert 'u')

public class EditDistance {

    private static int getMinimum(int[] arr){
        int min = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]<min){
                min = arr[i];
            }
        }
        return min;
    }

    /**
     * Time complexity: O( 3 ^ min( len of word1,len of word2 ) )
     * Space complexity: O(len of word1 + len of word2)
     */
    public static int editDistance(String word1, String word2) {
        if(word1.length()==0) return word2.length();
        if(word2.length()==0) return word1.length();

        if(word1.charAt(word1.length() - 1) == word2.charAt(word2.length()-1)){
            return editDistance(word1.substring(0,word1.length()-1),word2.substring(0,word2.length()-1));
        }else{
            return 1 + getMinimum(new int[]{
                    editDistance(word1.substring(0, word1.length() - 1), word2.substring(0, word2.length() - 1)),
                    editDistance(word1.substring(0, word1.length() - 1), word2),
                    editDistance(word1, word2.substring(0, word2.length() - 1))
            });
        }
    }


    private static int editDistanceDPHashMap( HashMap<String,Integer> map, String word1, String word2) {
        if(word1.length() == 0) return word2.length();
        if(word2.length() == 0) return word1.length();

        StringBuilder key = new StringBuilder();
        key.append(word1);
        key.append(word2);

        if(!map.containsKey(key.toString())){
            int minDistance;
            if(word1.charAt(word1.length()-1)==word2.charAt(word2.length()-1)){
                minDistance = editDistanceDPHashMap(map,word1.substring(0,word1.length()-1),word2.substring(0,word2.length()-1));
            }else{
                minDistance = 1 + getMinimum(new int[]{
                            editDistanceDPHashMap(map,word1.substring(0,word1.length()-1),word2.substring(0,word2.length()-1)),
                            editDistanceDPHashMap(map,word1.substring(0,word1.length()-1),word2),
                            editDistanceDPHashMap(map,word1,word2.substring(0,word2.length()-1))
                        });
            }
            map.put(key.toString(),minDistance);
        }
        return map.get(key.toString());
    }


    /**
     *  Time complexity: O(len of word1 * len of word2)
     *  Space complexity: hashmap + recursive calls => O(len of word1 * len of word2) + O(len of word1 + len of word2)
     */
    public static int editDistanceDPHashMap( String word1, String word2){
        HashMap<String,Integer> map = new HashMap<>();
        return editDistanceDPHashMap(map,word1,word2);
    }

    private static int editDistanceDPArrays(int[][] table, String word1, String word2, int i, int j) {
        if(i==-1 && j==-1) return 0;
        if(i==-1) return j+1;
        if(j==-1) return i+1;
        if(table[i][j] == -5){
            if(word1.charAt(i) == word2.charAt(j)){
                table[i][j] = editDistanceDPArrays(table, word1, word2, i-1, j-1);
            }else{
                table[i][j] = 1 + getMinimum(new int[]{
                        editDistanceDPArrays(table, word1, word2, i-1, j-1),
                        editDistanceDPArrays(table, word1, word2, i-1, j),
                        editDistanceDPArrays(table, word1, word2, i, j-1)
                });
            }
        }
        return table[i][j];
    }

    /**
     *  Time complexity: O(len of word1 * len of word2)
     *  Space complexity: array size + recursive calls => O(len of word1 * len of word2) + O(len of word1 + len of word2)
     */
    public static int editDistanceDPArrays( String word1, String word2){
        int[][] table = new int[word1.length()+1][word2.length()+1];
        for(int[] arr: table){
            Arrays.fill(arr,-5);
        }
        return editDistanceDPArrays(table,word1,word2,word1.length()-1,word2.length()-1);
    }

    public static int editDistanceDPArraysIterative(String word1,String word2){
        int[][] table = new int[word1.length()+1][word2.length()+1];

        for(int i=0;i<=word1.length();i++){
            table[i][0] = i;
        }

        for(int i=0;i<=word2.length();i++){
            table[0][i] = i;
        }


        for(int i=1;i<=word1.length();i++){
            for(int j=1;j<=word2.length();j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    table[i][j] = table[i-1][j-1];
                }else{
                    table[i][j] = getMinimum(new int[]{table[i-1][j-1],table[i-1][j],table[i][j-1]}) + 1;
                }
            }
        }

        return table[word1.length()][word2.length()];
    }



    public static void main(String[] args){
        System.out.println(editDistanceDPArraysIterative("maple","kale")); // 2
        System.out.println(editDistanceDPArraysIterative("horse","ros")); // 3
        System.out.println(editDistanceDPArraysIterative("intention","execution")); // 5
        System.out.println(editDistanceDPArraysIterative("dinitrophenylhydrazine","benzalphenylhydrazone")); // 7
        System.out.println(editDistanceDPArraysIterative("hello","hola")); // 3
        System.out.println(editDistanceDPArraysIterative("hello","hello")); // 0
    }
}
