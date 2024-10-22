package algorithms.labs.lab11;

import java.util.*;

public class CoursesScheduleKahnOptimized {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegreeList = new int[numCourses];
        List<List<Integer>> adjList = new ArrayList<>();

        // initialize out list or adjacency list
        for(int i=0;i<numCourses;i++){
            adjList.add(new ArrayList<>());
        }
        // populate adjacency list
        for(int[] pre: prerequisites){
            adjList.get(pre[1]).add(pre[0]);
        }

        for(int i=0;i<numCourses;i++){
            for(int it: adjList.get(i)){
                inDegreeList[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        // insert nodes with in-degree = 0 to the front of queue
        for(int i=0;i< inDegreeList.length;i++){
            if(inDegreeList[i] == 0){
                q.offer(i);
            }
        }

//        System.out.println(Arrays.toString(inDegreeList));
//        System.out.println(adjList);

        int[] result = new int[numCourses];
        int index = 0;
        while(!q.isEmpty()){
            int i = q.poll();
            result[index++] = i;
            for(int node: adjList.get(i)){
                inDegreeList[node]--;
                if(inDegreeList[node] == 0){
                    q.offer(node);
                }
            }
        }

        if(index!=numCourses){
            // cycle was detected
            return new int[]{};
        }

        return result;
    }
    public static void main(String[] args){
        System.out.println(Arrays.toString(findOrder(2,new int[][]{new int[]{1,0}}))); // [0,1]
        System.out.println(Arrays.toString(findOrder(4,new int[][]{new int[]{1,0},new int[]{2,0},new int[]{3,1},new int[]{3,2}}))); // [0,2,1,3]
        System.out.println(Arrays.toString(findOrder(1,new int[][]{}))); // [0]
        System.out.println(Arrays.toString(findOrder(2,new int[][]{new int[]{0,1},new int[]{1,0}}))); // []
        System.out.println(Arrays.toString(findOrder(3,new int[][]{new int[]{1,0},new int[]{1,2},new int[]{0,1}}))); // []
        System.out.println(Arrays.toString(findOrder(3,new int[][]{new int[]{0,2},new int[]{1,2},new int[]{2,0}}))); // []

    }
}
