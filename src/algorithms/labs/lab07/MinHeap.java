package algorithms.labs.lab07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MinHeap<T extends Comparable<T>>{

    List<T> heap;
    MinHeap(){
        this.heap = new ArrayList<>();
    }

    private int getParentIndex(int i){
        return (i-1)/2;
    }
    private int getRightChildIndex(int i){
        return 2*i + 2;
    }
    private int getLeftChildIndex(int i){
        return 2*i + 1;
    }

    private void swap(int i, int j){
        T temp = this.heap.get(i);
        this.heap.set(i,this.heap.get(j));
        this.heap.set(j,temp);
    }

    private int getSmallestChildIndex(int currIndex){
        int leftIndex = getLeftChildIndex(currIndex);
        int rightIndex = getRightChildIndex(currIndex);

        int smallestIndex = currIndex;

        if(leftIndex > 0 && leftIndex < this.heap.size() && this.heap.get(leftIndex).compareTo(this.heap.get(smallestIndex)) < 0){
            smallestIndex = leftIndex;
        }

        if(rightIndex> 0 && rightIndex < this.heap.size() && this.heap.get(rightIndex).compareTo(this.heap.get(smallestIndex)) < 0){
            smallestIndex = rightIndex;
        }
        return smallestIndex;

    }

    public T getMin(){
        if(this.heap.isEmpty()){
            throw new Error("heap is empty");
        }
        T currMin = this.heap.getFirst();
        T lastElement = this.heap.removeLast();

        if(!this.heap.isEmpty()){
            this.heap.set(0,lastElement);
            int currPosition = 0;

            while(true){
                int smallestIndex = getSmallestChildIndex(currPosition);
                if(smallestIndex == currPosition){
                    break;
                }
                swap(currPosition,smallestIndex);
                currPosition = smallestIndex;
            }
        }
        return currMin;
    }

    public void insert(T val){
        this.heap.add(val);
        int currentIndex = this.heap.size()-1;
        while(currentIndex >= 0 && this.heap.get(currentIndex).compareTo(this.heap.get(getParentIndex(currentIndex))) < 0 ){
            swap(currentIndex,getParentIndex(currentIndex));
            currentIndex = getParentIndex(currentIndex);
        }
    }
}


class Solution {
    static class Node implements Comparable<Node> {
        int[] point;
        double distance;
        Node(int[] point){
            this.point = point;
            this.distance = Math.pow(Math.pow(point[0],2)+ Math.pow(point[1],2),0.5);
        }

        public int compareTo(Node obj){
            return Double.compare(this.distance, obj.distance);
        }
    }
    public static int[][] kClosest(int[][] points, int k) {
        MinHeap<Node> heap = new MinHeap<>();
        for(int[] arr: points){
            heap.insert(new Node(arr));
        }

        int[][] result = new int[k][2];
        for(int i=0;i<k;i++){
            result[i] = heap.getMin().point;
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(Arrays.deepToString(kClosest(new int[][]{new int[]{1, 3}, new int[]{-2, 2}, new int[]{-2, 0}, new int[]{0,0}, new int[]{4, 2}}, 6)));
    }
}
