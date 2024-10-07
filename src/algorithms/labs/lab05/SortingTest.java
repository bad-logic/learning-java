package algorithms.labs.lab05;

import algorithms.labs.lab02.MergeSortHybrid;
import algorithms.labs.practise.util.RandomPermutations;

import algorithms.labs.lab02.InsertionSort;

public class SortingTest {

    public static void main(String[] args){
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
            MergeSortHybrid.mergeSort(arr,0,arr.length - 1);
        }
        end = System.nanoTime();
        System.out.println("time taken to execute: "+ ((end - start)/1000000) + "ms");

        System.out.println("MERGE SORT PLUS VERSION");
        start = System.nanoTime();
        for( int[] arr: arrs){
            MergeSortHybrid.mergeSortPlus(arr,0,arr.length - 1);
        }
        end = System.nanoTime();
        System.out.println("time taken to execute: "+ ((end - start)/1000000) + "ms");

        System.out.println("BST SORT VERSION");
        start = System.nanoTime();
        for( int[] arr: arrs){
            new BSTSort(arr).sort();
        }
        end = System.nanoTime();
        System.out.println("time taken to execute: "+ ((end - start)/1000000) + "ms");


    }
}
