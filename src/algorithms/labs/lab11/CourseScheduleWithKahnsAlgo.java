package algorithms.labs.lab11;

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


// REFERENCE: https://www.geeksforgeeks.org/topological-sorting-indegree-based-solution/


import java.util.*;

public class CourseScheduleWithKahnsAlgo {

//    static class Queue<T>{
//        class Node{
//            T val;
//            Node prev;
//            Node(T val){
//                this.val = val;
//            }
//        }
//
//        Node head;
//        Node tail;
//        int size = 0;
//
//        private void reset(){
//            this.tail = null;
//            this.head = null;
//        }
//
//        Queue(){
//            this.reset();
//        }
//
//        public void enqueue(T v){
//                Node n = new Node(v);
//                if(head == null || tail == null){
//                    this.head = n;
//                    this.tail = n;
//                }else{
//                    this.head.prev = n;
//                    this.head = n;
//                }
//                size++;
//        }
//
//        public T dequeue(){
//            if(isEmpty()){
//                return null;
//            }
//            Node n = this.tail;
//            this.tail = this.tail.prev;
//            size--;
//            if(size==0){
//                this.reset();
//            }
//            return n.val;
//        }
//
//        public int size(){
//            return this.size;
//        }
//
//        public T peekHead(){
//            return head != null ? head.val : null;
//        }
//
//        public T peekTail(){
//            return tail != null ? tail.val : null;
//        }
//
//        public boolean isEmpty(){
//            return this.size == 0;
//        }
//
//    }


    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> inList = new ArrayList<>();
        List<List<Integer>> adjList = new ArrayList<>();

        Queue<Integer> q = new LinkedList<>();;

        // initialize in list and out list/adjacency list
        for(int i=0;i<numCourses;i++){
            inList.add(new ArrayList<>());
            adjList.add(new ArrayList<>());
        }

        // populate in list and outlist
        for(int[] pre: prerequisites){
            inList.get(pre[0]).add(pre[1]);
            adjList.get(pre[1]).add(pre[0]);
        }
        // insert nodes with in-degree = 0 to the front of queue
        for(int i=0;i<inList.size();i++){
            if(inList.get(i).isEmpty()){
                q.offer(i);
            }
        }

//        System.out.println(inList);
//        System.out.println(adjList);
        List<Integer> result = new ArrayList<>(numCourses);
        while(!q.isEmpty()){
            int i = q.poll();
            result.add(i);
            for(int node: adjList.get(i)){
                List<Integer> ls = inList.get(node);
                ls.remove((Integer) i);
                if(ls.isEmpty()){
                    q.offer(node);
                }
            }
        }

        if(result.size()!=numCourses){
            // cycle was detected
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
