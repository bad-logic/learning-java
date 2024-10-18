package algorithms.challenge;

// TASK SCHEDULING
//The data analysts of xyz company wants to schedule some long-running tasks on remote servers optimally to minimize the
//cost of running them locally. The analysts have two servers, a paid one and a free one. The free server can be used only
//if the paid server is occupied.
//
// The ith task is expected to take time[i] units of time to complete and the cost of processing
// the task on the paid server is cost[i]. The task can be run on the free server only if some task
// is already running on the paid server.The cost of the free server is 0 and it can process
// any task in 1 unit of time.
//
//Find the minimum cost to complete all the tasks if tasks are scheduled optimally.
//
//Example
//
//Suppose n = 4, cost = [1, 1, 3, 4] and time = [3, 1, 2, 3]
//The first task must be scheduled on the paid server for a cost of 1 and it takes 3 units of time to complete.
//In the meantime, the other three tasks are executed on the free server for no cost as the free server takes
//only 1 unit to complete any task. Return the total cost, 1.
//
//n = 4, time = [1,2,3,2], cost = [1,2,3,2], mincost = 3
//n = 4, time = [1,1,1,1], cost = [2,3,4,2], mincost =  4
//n = 4 ,time = [1,2,3,2], cost = [3,2,3,2], mincost =  3
//
//public int getMinCost(int[] cost, int[] time) {
//    //write your code here
//
//
//}

import java.security.InvalidParameterException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Scheduling {
    private static List<List<Integer>> getCombinations(List<List<Integer>> result, List<Integer> subset, List<Integer> data, int choose, int index){
        if(subset.size() == choose){
            result.add(new ArrayList<>(subset));
            return result;
        }

        for(int i=0;i<data.size();i++){
            if(index == i) {
                continue;
            }
            subset.add(data.get(i));
            getCombinations(result,subset,data,choose,i);
            subset.removeLast();
        }
        return result;
    }

    private static int[] deleteIndex(int[] arr, int index ){
        if(index > arr.length || index < 0) throw new InvalidParameterException("index out of bounds");
        int[] newArr = new int[arr.length - 1];
        int j = 0;
        for(int i=0;i<arr.length;i++){
            if(i==index) continue;
            newArr[j] = arr[i];
            j++;
        }
        return newArr;
    }

//    private static final int[] table = new int[50];
//
//    private static int fact(int n){
//        if(table[n]!= 0) return table[n];
//        if(n==0||n==1) return 1;
//        table[n] = n*fact(n-1);
//        return table[n];
//    }

    public static int[][] getCombinations(int[] data, int choose){
        // @TODO optimize to remove duplicates
        //  there are duplicates in this combinations
        // ignoring for now. since they do not affects the result in anyway
        List<List<Integer>> combs = getCombinations(
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>(Arrays.stream(data).boxed().collect(Collectors.toList())),
                choose,
                0
        );
//       int numberOfCombinations = fact(data.length)/(fact(data.length - choose)*fact(choose));

        int[][] result = new int[combs.size()][choose];
        int pos = 0;
        for(List<Integer> it: combs){
            int[] arr = new int[choose];
            int i=0;
            while(i<choose){
                arr[i] = it.get(i);
                i++;
            }
            result[pos] = arr;
            pos++;
        }
        return result;
    }

    private static int process(int[] time, int[] cost, int timeOnFreeServer, int index, ArrayList<String> strategy){

        strategy.add("Got index: "+ index + "\n time: "+ Arrays.toString(time) +"\n cost: "+Arrays.toString(cost) + "\n time on server: " + timeOnFreeServer);

        if(timeOnFreeServer >= time.length){
            return 0; // no extra cost
        }

        if(timeOnFreeServer == 0){
            // pick the task at index to be processed in paid server and  process the remaining tasks
            return cost[index] + process(deleteIndex(time,index),deleteIndex(cost,index),time[index],0,strategy);
        }

        int minCost = Integer.MAX_VALUE;
        int tasksRemaining = time.length - timeOnFreeServer;
        // create combinations of tasks that can be taken from the available tasks
        int[] newTasks = new int[time.length];
        IntStream.range(0,time.length).forEach(i->Arrays.fill(newTasks,i,i+1,i));

        for(int[] comb: getCombinations(newTasks,tasksRemaining)){
            int[] newTime = new int[tasksRemaining];
            int[] newCost = new int[tasksRemaining];
            int k = 0;
            for(int i:comb){
                newTime[k] = time[i];
                newCost[k] = cost[i];
                k++;
            }
            for(int i=0;i<tasksRemaining;i++) {
                minCost = Math.min(minCost, process( newTime,newCost, 0,i,strategy));
            }
        }
        return minCost;
    }

    public static int getMinCost(int[] time, int[] cost) {
        //write your code here
        int minCost = Integer.MAX_VALUE;
        ArrayList<ArrayList<String>> strategy = new ArrayList<>();
        for(int i=0;i<time.length;i++){
            ArrayList<String> st = new ArrayList<>();
            int c = process(time, cost,0, i,st);
            minCost = Math.min(minCost, c);
            st.add("\n cost: "+ c+"\n\n ################ Next loop");
            strategy.add(st);
        }
//        System.out.println(strategy);
        return minCost;
    }

    public static void main(String[] args) {

        int[] time = new int[]{1,2,3,2};
        int[] cost = new int[]{1,2,3,2};

        long start = System.nanoTime();
        int temp = getMinCost(time, cost);
        long end =System.nanoTime();
        System.out.println("ans: "+temp+", time: "+ (end-start)/(100000) + "ms"); // Expected output should be 3

        time = new int[]{3,1,2,3};
        cost = new int[]{1,1,3,4};

        start = System.nanoTime();
        temp = getMinCost(time, cost);
        end =System.nanoTime();
        System.out.println("ans: "+temp+", time: "+ (end-start)/(100000) + "ms"); // Expected output should be 1

        time = new int[]{1,1,1,1};
        cost = new int[]{2,3,4,2};

        start = System.nanoTime();
        temp = getMinCost(time, cost);
        end =System.nanoTime();
        System.out.println("ans: "+temp+", time: "+ (end-start)/(100000) + "ms"); // Expected output should be 4

        time = new int[]{1,2,3,2};
        cost = new int[]{3,2,3,2};

        start = System.nanoTime();
        temp = getMinCost(time, cost);
        end = System.nanoTime();
        System.out.println("ans: "+temp+", time: "+ (end-start)/(100000) + "ms"); // Expected output should be 3

    }

}
