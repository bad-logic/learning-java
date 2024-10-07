package algorithms.labs.lab02;

public class InsertionSort {

    public static int[] insertionSort(int[] arr,int s, int e){
        for(int i=s+1 ; i<=e ; i++){
            int j = i;
            int temp = arr[j];
            while(j > s && arr[j-1] > temp){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;
        }
        return arr;
    }


}
