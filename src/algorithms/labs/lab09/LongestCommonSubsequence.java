package algorithms.labs.lab09;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static int longestCommonSubsequence(int[][] memo, String text1, String text2, int p , int q) {
        if(p == text1.length() || q ==  text2.length()){
            return 0;
        }
        if(memo[p][q]==-5){
            if(text1.charAt(p)==text2.charAt(q)){
                memo[p][q] =  1 + longestCommonSubsequence(memo,text1,text2,p+1,q+1);
            }else{
                memo[p][q] =  Math.max( longestCommonSubsequence(memo,text1,text2,p+1,q), longestCommonSubsequence(memo,text1,text2,p,q+1));
            }
        };
        return memo[p][q];
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] memos = new int[text1.length()][text2.length()];
        for (int[] memo : memos) {
            Arrays.fill(memo, -5);
        }
        return longestCommonSubsequence(memos, text1,text2,0,0);
    }


    public static void main(String[] args){
        System.out.println(longestCommonSubsequence("abcd","abghijd")); // 3
        System.out.println(longestCommonSubsequence("ezupkr","ubmrapg")); // 2
    }
}
