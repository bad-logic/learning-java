package algorithms.labs.lab02;
import algorithms.labs.practise.util.RandomPermutations;


// PSEUDO CODE

//Algorithm copyArr(arr, s, e)
//    Input: original array to copy and s and e index range to be copied both inclusive
//    Ouput: copies array from index s to e from original array
//
//    length <-- e - s + 1
//    newArr <- new arr[length]
//    pos <-- 0
//    while s <= e do
//        newArr[pos] = arr[s]
//        s++
//        pos++
//    return newArr
//
//Algorithm insertionSort(arr,s,e)
//    Input: Array to be sorted and its start and end index
//    Output: Array sorted from index s to e, both index inclusive
//
//    for i <-- s + 1 to e do
//        j <-- i
//        temp <-- arr[j]
//        while j > s and arr[j -1] > arr[j] do
//            arr[j] <-- arr[j-1]
//            j--
//        arr[j] <-- temp
//    return arr
//
//
//Array merge(arr,s,m,e)
//    Input: Original array, s , m, e define start, middle and end index for sub partition array
//    Output: Array sorted from index s to e, both index inclusive
//
//    arr1 <-- copyArr(arr,s,m)
//    arr2 <-- copyArr(arr,m+1,e)
//
//    arr1Length <-- m - s + 1
//    arr2Length <-- e - m
//
//    arr1Cursor <-- 0
//    arr2Cursor <-- 0
//    pos <-- s
//
//
//    while arr1Cursor < arr1Length and arr2Cursor < arr2Length do
//        if arr1[arr1Cursor] <= arr2[arr2Cursor] then
//            arr[pos] = arr1[arr1Cursor]
//            arr1Cursor++
//        else
//            arr[pos] = arr2[arr2Cursor]
//            arr2Cursor++
//        pos++
//
//        if arr1Cursor = arr1Length then
//            while arr2Cursor < arr2Length do
//                arr[pos] = arr2[arr2Cursor]
//                arr2Cursor++
//                pos++
//        if arr2Cursor = arr2Length then
//            while arr1Cursor < arr1Length do
//                arr[pos] = arr2[arr1Cursor]
//                arr1Cursor++
//                pos++
//
//    return arr
//
//
//Algorithm mergeSort(arr,s,e)
//    Input: Array to be sorted and its start and end index
//    Output: Sorted Array
//
//    if(s=e) then return arr
//    if(e-s+1 <= 20) return insertionSort(arr,s,e);
//    m <-- floor((s+e)/2)
//    mergeSort(arr,s,m)
//    mergeSort(arr,m+1,e)
//    merge(arr,s,m,e)
//    return arr

public class MergeSortHybrid {
    public static int[] getArrayCopy(int[] arr,int s, int e){
        int length = e - s + 1;
        int[] newArray = new int[length];
        System.arraycopy(arr,s,newArray,0,length);
        return newArray;
    }

    public static int[] merge(int[] arr, int s, int m, int e){

        int arrayALength = m - s + 1;
        int arrayBLength = e - m;

        int[] arrA = getArrayCopy(arr,s,m);
        int[] arrB = getArrayCopy(arr,m+1,e);
        int cursorA = 0;
        int cursorB = 0;

        int pos = s;

        while(cursorA < arrayALength && cursorB < arrayBLength){
            if(arrA[cursorA] > arrB[cursorB]){
                arr[pos] = arrB[cursorB];
                cursorB++;
            }else{
                arr[pos] = arrA[cursorA];
                cursorA++;
            }
            pos++;
        }

        if(cursorA == arrayALength){
            System.arraycopy(arrB,cursorB,arr, pos, arrayBLength - cursorB );
        }
        if(cursorB == arrayBLength){
            System.arraycopy(arrA,cursorA,arr, pos, arrayALength - cursorA );
        }

        return arr;
    }

    public static int[] mergeSortPlus(int[] arr,int s,int e){
        if(s==e) return arr;
        if(e-s+1 <= 20) return InsertionSort.insertionSort(arr,s,e);
        int m = (s+e)/2;
        mergeSortPlus(arr,s,m);
        mergeSortPlus(arr,m+1,e);
        merge(arr,s,m,e);
        return arr;
    }

    public static int[] mergeSort(int[] arr,int s,int e){
        if(s==e) return arr;
        int m = (s+e)/2;
        mergeSort(arr,s,m);
        mergeSort(arr,m+1,e);
        merge(arr,s,m,e);
        return arr;
    }
    public static void main(String[] args){
//        int[] arr = new int[]{77,78,99,1001,2003,45,67,89,0,1,45,33,56,78,99,10001,12345,67,32,22,11,76,89,96,108,120,2000,2001,2020,0,45,66,78,56,23,111,121,144,256,7,51};
//        System.out.println(Arrays.toString(insertionSort(arr,0,arr.length-1)));
//        System.out.println(Arrays.toString(mergeSort(arr,0,arr.length-1)));
//        System.out.println(Arrays.toString(mergeSortPlus(arr,0,arr.length-1)));

        int[][] arrs = new int[500][10000];
        for(int i = 0; i < 500; ++i){
            arrs[i] = RandomPermutations.nextArray2(10000);
        }

        System.out.println("INSERTION SORT VERSION");
        var start = System.nanoTime();
        for( int[] arr: arrs){
            InsertionSort.insertionSort(arr,0,arr.length - 1);
        }
        var end = System.nanoTime();
        System.out.println("time taken to execute: "+ ((end - start)/1000000) + "ms");

        System.out.println("MERGE SORT VERSION");
        start = System.nanoTime();
        for( int[] arr: arrs){
            mergeSort(arr,0,arr.length - 1);
        }
        end = System.nanoTime();
        System.out.println("time taken to execute: "+ ((end - start)/1000000) + "ms");

        System.out.println("MERGE SORT PLUS VERSION");
        start = System.nanoTime();
        for( int[] arr: arrs){
            mergeSortPlus(arr,0,arr.length - 1);
        }
        end = System.nanoTime();
        System.out.println("time taken to execute: "+ ((end - start)/1000000) + "ms");

    }

}
