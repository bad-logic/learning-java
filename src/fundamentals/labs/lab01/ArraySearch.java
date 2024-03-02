package lab01;

public class ArraySearch {
	
	public static int search(int arr[], int target) {
		int searchIndex = -1;
		for(int i=0;i<arr.length;++i) {
			if(arr[i] == target) {
				searchIndex = i;
				break;
			}
		}
		return searchIndex;
	}
	
	public static void main(String[] args) {
		System.out.println("Array Search");
	}

}
