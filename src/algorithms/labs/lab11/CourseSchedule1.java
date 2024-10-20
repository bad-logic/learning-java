package algorithms.labs.lab11;

//There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
//You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must
//take course bi first if you want to take course ai.
//
//For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
//Return true if you can finish all courses. Otherwise, return false.
//
//Example 1:
//
//Input: numCourses = 2, prerequisites = [[1,0]]
//Output: true
//Explanation: There are a total of 2 courses to take.
//To take course 1 you should have finished course 0. So it is possible.
//Example 2:
//
//Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
//Output: false
//Explanation: There are a total of 2 courses to take.
//To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CourseSchedule1 {

    public boolean dfs(int node, List<List<Integer>> adjList, Set<Integer> visited, Set<Integer> cycle){
        if(cycle.contains(node)) return false;

        if(visited.contains(node)) return true;

        cycle.add(node);
        for(int n: adjList.get(node)){
            if(!dfs(n,adjList,visited,cycle)){
                return false;
            }
        }

        cycle.remove(node);
        visited.add(node);
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            adjList.add(i,new ArrayList<>());
        }

        for(int[] pre: prerequisites){
            adjList.get(pre[0]).add(pre[1]);
        }

        Set<Integer> visited = new HashSet<>();
        Set<Integer> cycle = new HashSet<>();

        for(int i=0;i<numCourses;i++){
            if(!dfs(i,adjList,visited,cycle)){
                return false; // cycle detected
            }
        }
        // if(visited.size != numCourses){
        //     return false; // cannot take all courses
        // }

        return true;
    }

}
