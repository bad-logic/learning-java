package algorithms.challenge;

//find the minimum number of operations needed to get a positive integer 34
//from 1 using only 3 primitive operations :
//1. add 1
//2. multiply by 2
//3. multiply by 3




public class MinNumOperations {

    // can be optimized for generic solution
    // by using memoization
    public static int getOperationsCount(int val, int target){
        if(val == target){
            return 1;
        }

        if(val > target){
            return Integer.MAX_VALUE;
        }

        int c1 = getOperationsCount(val+1,target);
        int c2 = getOperationsCount(val*2,target);
        int c3 = getOperationsCount(val*3,target);

        int min1 = Math.min(c1,c2);
        return 1 + Math.min(min1,c3);
    }


    public static void main(String[] args){

        int minOperations = getOperationsCount(1,34) - 1;
        if(minOperations == Integer.MAX_VALUE) System.out.println("cannot get to the target value");
        System.out.println(minOperations);

    }
}
