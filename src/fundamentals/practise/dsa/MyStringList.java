package fundamentals.practise.dsa;

import java.util.Arrays;

public class MyStringList {
   final private int INITIAL_LENGTH = 16;
   final private String[] strArray;
   private int size;

   public MyStringList(){
       strArray = new String[INITIAL_LENGTH];
       size = 0;
   }

   void swap(int i, int j){
       String temp = strArray[i];
       strArray[i] = strArray[j];
       strArray[j] = temp;
   }

   private int minPos(int lower,int upper){
       int minPos = lower;
       for(int i=lower;i<=upper;i++){
           if(strArray[i].compareTo(strArray[minPos]) < 0){
               minPos = i;
           }
       }
       return minPos;
   }

   public void add(String s){
       strArray[size] = s;
       size++;
   }

   public String toString(){
       return Arrays.toString(Arrays.copyOf(this.strArray,size));
   }

   public void minSort(){
       if(this.strArray == null || this.size <= 1)return;

       for(int i=0;i<size;i++){
            int minPos = minPos(i,size-1);
            swap(i,minPos);
       }
   }

   public static void main(String[] args){
       MyStringList ml = new MyStringList();
       ml.add("hello");
       ml.add("Happy");
       ml.add("nice work");
       ml.add("aaaaa");
       ml.add("abc");
       ml.add("a");
       ml.add("A");
       System.out.println(ml);
       ml.minSort();
       System.out.println(ml);
   }

}
