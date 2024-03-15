package fundamentals.labs.lab08.lab08_01;

import java.util.Arrays;

public class MyStringList {
    private final int INITIAL_LENGTH = 4;
    private String[] strArray;
    private int size;
    private boolean isSorted = false;

    public MyStringList() {
        strArray = new String[INITIAL_LENGTH];
        size = 0;
    }

    private void resize(){
        System.out.println("resizing");
        int len = strArray.length;
        int newlen = 2 * len;
        String[] temp = new String[newlen];
        System.arraycopy(strArray,0,temp,0,len);
        strArray = temp;
    }

    public int size() {
        return size;
    }

    public String get(int i){
        if(i < 0 || i >= size){
            return null;
        }
        return strArray[i];
    }

    public boolean find(String s){
        for(String test : strArray){
            if(test.equals(s)) return true;
        }
        return false;
    }

    public void add(String s){
        if(size == strArray.length) resize();
        strArray[size++] = s;
    }

    public void insert(String s, int pos){
        if(pos > size) return;
        if(pos >= strArray.length||size+1 > strArray.length) {
            resize();
        }
        String[] temp = new String[strArray.length+1];
        System.arraycopy(strArray,0,temp,0,pos);
        temp[pos] = s;

        System.arraycopy(strArray,pos,temp,pos+1, strArray.length - pos);
        strArray = temp;
        ++size;

    }

    public boolean remove(String s){
        if(size == 0) return false;
        int index = -1;
        for(int i = 0; i < size; ++i ){
            if(strArray[i].equals(s)){
                index = i;
                break;
            }
        }
        if(index==-1) return false;
        String[] temp = new String[strArray.length];
        System.arraycopy(strArray,0,temp,0,index);
        System.arraycopy(strArray,index+1,temp,index,strArray.length-(index+1));
        strArray = temp;
        --size;
        return true;
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

    /******* sorting methods ********/
    public void minSort(){
        if(this.strArray == null || this.size <= 1)return;

        for(int i=0;i<size;i++){
            int minPos = minPos(i,size-1);
            swap(i,minPos);
        }
        isSorted = true;
    }


    /******** binary search methods ********/

    //search a sorted array
    boolean binSearchIt(String s) {
        if(!isSorted){
            this.minSort();
        }

        int lower = 0;
        int upper = this.strArray.length;

        while(true){
            if(lower > upper) return false;
            int midPos = (upper + lower) / 2;
            if(this.strArray[midPos].equals(s)) return true;
            if(s.compareTo(this.strArray[midPos]) > 0){
                lower = midPos + 1;
            }else{
                upper = midPos - 1;
            }
        }
    }

    /********* end binary search methods *****/

    public String toString(){
        return Arrays.toString(Arrays.copyOf(this.strArray,size));
    }

    public static void main(String[] args){
        MyStringList ml = new MyStringList();
        ml.add("big");
        ml.add("small");
        ml.add("tall");
        ml.add("short");
        ml.add("round");
        ml.add("square");
        ml.add("enormous");
        ml.add("tiny");
        ml.add("gargantuan");
        ml.add("lilliputian");
        ml.add("numberless");
        ml.add("none");
        ml.add("vast");
        ml.add("miniscule");

        System.out.println(ml);
        ml.minSort();
        System.out.println(ml);
        System.out.println("searching \"number\": "+ ml.binSearchIt("number"));
        System.out.println("searching \"tiny\": "+ ml.binSearchIt("tiny"));
    }

}
