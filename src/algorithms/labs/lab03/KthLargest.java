package algorithms.labs.lab03;

//Given an integer array nums and an integer k, return the kth largest element in the array.
//Note that it is the kth largest element in the sorted order, not the kth distinct element.
//Can you solve it without sorting ?

public class KthLargest {
    public static int quickSortedIndex(int[] arr, int s, int e){
        int pivot = arr[e];
        int pos = s;
        for(int i=s;i<e;i++){
            if(arr[i] < pivot){
                if(pos != i){
                    int temp = arr[pos];
                    arr[pos] = arr[i];
                    arr[i] = temp;
                }
                pos++;
            }
        }
        arr[e] = arr[pos];
        arr[pos] = pivot;
        return pos; // pos is the correct position of that element in the array.
    }

    public static int largestAtKPosition(int[] nums, int k){
        int position = nums.length - k;
        int start = 0;
        int end = nums.length - 1;
        while(start < end){ // element in position or index is the of the correct order
            int cursor = quickSortedIndex(nums,start,end);
            if(cursor==position){
                break;
            }
            if(position < cursor){
                end = cursor - 1;
            }else{
                start = cursor + 1;
            }
        }
        return nums[position];
    }

    public static void main(String[] args){
        System.out.println(largestAtKPosition(new int[]{3,2,1,5,6,4},2)); // 5
        System.out.println(largestAtKPosition(new int[]{3,2,3,1,2,4,5,5,6},4)); // 4
        System.out.println(largestAtKPosition(new int[]{1,70,3,4,5,6,3,7,80,0},2)); // 70
        System.out.println(largestAtKPosition(new int[]{1},1)); // 1
        System.out.println(largestAtKPosition(new int[]{2,1},2)); // 1

    }
}
