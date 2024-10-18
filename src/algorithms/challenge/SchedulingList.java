package algorithms.challenge;

// TASK SCHEDULING
//The data analysts of Hackerland want to schedule some long-running tasks on remote servers optimally to minimize the
//cost of running them locally. The analysts have two servers, a paid one and a free one. The free server can be used only
//if the paid server is occupied.
//
// The ith task is expected to take time[i] units of time to complete and the cost of processing
// the task on the paid server is cost[i]. The task can be run on the free server only if some task
// is already running on the paid server.The cost of the free server is 0 and it can process
// any task in 1 unit of time.

//Find the minimum cost to complete all the tasks if tasks are scheduled optimally.

//Example

//Suppose n = 4, cost = [1, 1, 3, 4] and time = [3, 1, 2, 3]
//The first task must be scheduled on the paid server for a cost of 1 and it takes 3 units of time to complete.
//In the meantime, the other three tasks are executed on the free server for no cost as the free server takes
//only 1 unit to complete any task. Return the total cost, 1.

import java.util.ArrayList;
import java.util.List;

public class SchedulingList {
    private static List<List<List<Integer>>> getCombinations(List<List<List<Integer>>> result, List<List<Integer>> subset, List<List<Integer>> data, int choose, int index){
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

    public static List<List<List<Integer>>> getCombinations(List<List<Integer>>data, int choose){
        return getCombinations(new ArrayList<>(), new ArrayList<>(),data,choose,0);
    }

    private static int getMinimumCost(List<List<Integer>> data, int index){
        int taskAtHand = data.size();
        // process index task with paid server
        // and with the time it takes to process the paid server do other possible tasks
        List<Integer> timeCost = data.get(index);
        int time = timeCost.get(0);
        int cost = timeCost.get(1);

        // since c is the cost of task at index i
        // with free server taking unit time i can do next t tasks
        int tasksDone = 1 + time;
        int tasksRemaining = taskAtHand - tasksDone;
        if(tasksRemaining<=0){
            return cost;
        }
        int min = Integer.MAX_VALUE;
        for(List<List<Integer>> dt: getCombinations(data.subList(1,data.size()),tasksRemaining)){
            for(int i=0;i<tasksRemaining;i++){
                min = Math.min(min , getMinimumCost(dt,i));
            }
        }
        return cost + min;
    }

    /**
     *
     * @param timeCosts int[][] ; int[][]{new int[]{time,cost}}
     * @return
     */
    public static int getMinimumCost(int[][] timeCosts) {
        //write your code here
        int minCos = Integer.MAX_VALUE;
        int tasks = timeCosts.length;
        List<List<Integer>> data = new ArrayList<>();

        for(int i=0;i<timeCosts.length;i++){
            int temp = i;
            data.add(new ArrayList<>(){{
                add(timeCosts[temp][0]);
                add(timeCosts[temp][1]);
            }});
        }

        for(int i=0;i<tasks;i++){
            int c = getMinimumCost(data,i);
            if(c<minCos){
                minCos = c;
            }
        }
        return minCos;
    }

    public static void main(String[] args) {

        int[][] timeCost = new int[][]{
                new int[]{1,1},
                new int[]{2,2},
                new int[]{3,3},
                new int[]{2,2}
        };

        System.out.println(getMinimumCost(timeCost)); // Expected output should be 3

        timeCost = new int[][]{
                new int[]{3,1},
                new int[]{1,1},
                new int[]{2,3},
                new int[]{3,4}
        };
        System.out.println(getMinimumCost(timeCost)); // Expected output should be 1

        timeCost = new int[][]{
                new int[]{1,2},
                new int[]{1,3},
                new int[]{1,4},
                new int[]{1,2}
        };
        System.out.println(getMinimumCost(timeCost)); // Expected output should be 4

        timeCost = new int[][]{
                new int[]{1,3},
                new int[]{2,2},
                new int[]{3,3},
                new int[]{2,2}
        };
        System.out.println(getMinimumCost(timeCost)); // Expected output should be 3

    }

}
