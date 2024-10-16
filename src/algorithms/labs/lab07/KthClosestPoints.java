package algorithms.labs.lab07;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;


//Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k,
// return the k closest points to the origin (0, 0). The distance between two points on the X-Y plane is the
// Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2). You may return the answer in any order.
// The answer is guaranteed to be unique (except for the order that it is in).

//Example 1:
//Input: points = [[1,3],[-2,2]], k = 1
//Output: [[-2,2]]
//Explanation:
//The distance between (1, 3) and the origin is sqrt(10).
//The distance between (-2, 2) and the origin is sqrt(8).
//Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
//We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
//
//Example 2:
//Input: points = [[3,3],[5,-1],[-2,4]], k = 2
//Output: [[3,3],[-2,4]]
//Explanation: The answer [[-2,4],[3,3]] would also be accepted.


class KthClosestPoints {
    static class Node implements Comparable<Node> {
        int[] point;
        double distance;
        Node(int[] point){
            this.point = point;
            // ignoring square root because, we square root all points, which is the same
            // so removing common factor, for simplistic calculation
            this.distance = (Math.pow(point[0],2) + Math.pow(point[1],2));
        }


        public int compareTo(Node obj){
            return Double.compare(this.distance, obj.distance);
        }
    }

    PriorityQueue<Node> maxHeap = new PriorityQueue<Node>();

    public int[][] kClosest(int[][] points, int k) {
        for(int[] arr: points){
            maxHeap.add(new Node(arr));
        }

        int[][] result = new int[k][2];
        int length = points.length;
        int pos = 0;
        for(int i=0;i<k;i++){
            result[i] = maxHeap.poll().point;
        }
        return result;
    }
}