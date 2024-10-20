package algorithms.labs.lab11;


import java.util.*;

//There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites
//where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
//For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
//Return the ordering of courses you should take to finish all courses. If there are many valid answers, return
//any of them. If it is impossible to finish all courses, return an empty array.
//
//Example 1:
//Input: numCourses = 2, prerequisites = [[1,0]]
//Output: [0,1]
//Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0.
//So the correct course order is [0,1].
//
//Example 2:
//Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
//Output: [0,2,1,3]
//Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2.
//Both courses 1 and 2 should be taken after you finished course 0.
//So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
//
//Example 3:
//Input: numCourses = 1, prerequisites = []
//Output: [0]


public class CourseSchedule {

    private static boolean dfs(int node,List<List<Integer>> adjList, Set<Integer> visited, Set<Integer> path,List<Integer> result){
        if(path.contains(node)) return false; // cycle detected

        if(visited.contains(node)) return true; // no need to visit anymore

        List<Integer> dependencies = adjList.get(node);

        path.add(node);

        for(int dep: dependencies){
            if(!dfs(dep,adjList,visited,path,result)){
                return false;
            }
        }

        path.remove(node);
        visited.add(node);
        result.add(node);
        return true;
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();

        // initialize in list and out list/adjacency list
        for(int i=0;i<numCourses;i++){
            adjList.add(new ArrayList<>());
        }

        // adjacency list
        for(int[] pre: prerequisites){
            adjList.get(pre[0]).add(pre[1]);
        }

        Set<Integer> visited = new HashSet<>();
        Set<Integer> currentPath = new HashSet<>();

        List<Integer> result = new ArrayList<>(numCourses);

        for(int i=0;i<numCourses;i++){
            if(!dfs(i,adjList,visited,currentPath,result)){
                return new int[]{}; // cycle detected not possible to take all courses
            };
        }


        if(visited.size() != numCourses){
            // cannot take all courses
            return new int[]{};
        }


        return result.stream().mapToInt(Integer::intValue).toArray();
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
