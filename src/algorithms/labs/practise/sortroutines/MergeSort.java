package algorithms.labs.practise.sortroutines;

import algorithms.labs.practise.runtime.Sorter;



public class MergeSort extends Sorter {
	final int ARRAY_SIZE = 33;
	final int MAX_VAL = 1000;
	int[] theArray;


	//public sorter
	public int[] sort(int[] input){
		int n = input.length;
		int[] tempStorage = new int[n];
		theArray = input;
		mergeSort(tempStorage,0,n-1);
		return theArray;
	}

	//theArray[lower]...theArray[upper]
	void mergeSort(int[] tempStorage, int lower, int upper) {
		if(lower==upper){
			return;
		}

		else {
			//S1:theArray[lower]...theArray[mid]
			//S2:theArray[mid+1]...theArray[upper]
			int mid = (lower+upper)/2; //partition
			mergeSort(tempStorage,lower,mid);  //sort left half
			mergeSort(tempStorage,mid+1, upper); //sort right half
			merge(tempStorage,lower,mid+1,upper); //merge them
		}
	}
	
	//[4,16] 16-4+1=13

	/** Merges the ranges [lower, mid] and [midPlusOne,upper] in place */
	private void merge(int[] tempStorage, int lower, int midPlusOne, int upper) {
		int pos = 0; //tempStorage index
		//S1:theArray[lower]...theArray[mid]
		//S2:theArray[mid+1]...theArray[upper]
		int i = lower;
		int j = midPlusOne;
		int n = upper - lower + 1; //total number of elements to rearrange

		//view the range [lower,upper] as two arrays
        //[lower, mid], [midPlusOne,upper] to be merged

		while(i < midPlusOne && j <= upper){
			if(theArray[i] <= theArray[j])
				tempStorage[pos++] = theArray[i++];
			else 
				tempStorage[pos++] = theArray[j++];
			
		}
		while(i < midPlusOne) {
			tempStorage[pos++] = theArray[i++];
		}
		while(j <= upper){
			tempStorage[pos++] = theArray[j++];
		}
		//replace the range [lower,upper] in theArray with
		//the range [0,n-1] just created in tempStorage
		for(j=0; j<n; ++j) {
			theArray[lower+j] = tempStorage[j];
		}

	}

	//set up routines
	public static void main(String[] args){
		MergeSort ms = new MergeSort();
		//ms.testMerge();
		int[] arr = {1,4,2,5,6,1,7,9,0};
		int[] returnArr = ms.sort(arr);
		for (int i : returnArr) {
			System.out.print(i + " ");
		}
	}
	

}

