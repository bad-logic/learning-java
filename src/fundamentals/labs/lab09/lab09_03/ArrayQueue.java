package fundamentals.labs.lab09.lab09_03;

import java.util.Arrays;

public class ArrayQueue {
    private int[] arr = new int[10];
    private int size = 0;
    private int front = -1;
    private int rear = 0;

    private void resize(){
        // increase the size of the array
        int newSize = arr.length * 2;
        int[] temp = new int[newSize];
        System.arraycopy(arr,0,temp,0,arr.length);
        arr = temp;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size(){
        return size;
    }

    public int peek(){
        if(isEmpty()) throw new IllegalStateException("Cannot peek because Queue is empty!");
        return arr[front];
    }

    public void enqueue(int a){
        if(rear == 0){
            front = 0;
        }
        if(rear == arr.length){
            resize();
        }
        arr[rear++] = a;
        size++;
    }

    public void dequeue(){
        if(isEmpty()) throw new IllegalStateException("Cannot dequeue because Queue is empty!");
        int[] temp = new int[this.arr.length];
        System.arraycopy(this.arr,this.front + 1,temp,0,this.arr.length - 1);
        this.arr = temp;
        rear--;
        size--;
    }

    public String toString(){
        String output = "[ ";
        for(int i = this.front;i < this.rear; i++){
            output += this.arr[i] + " ";
        }
        output +="]";
        return  output;
    }


    public static void main(String[] args) {
        ArrayQueue q = new ArrayQueue();

        System.out.println("Enqueuing 0 to 14 to the queue");
		for(int i = 0; i < 15; i ++)
			q.enqueue(i);
        System.out.println("size: " + q.size());
        System.out.println("queue: " + q);
        System.out.println("peek: "+ q.peek());


        System.out.println("Dequeuing 14 elements from the queue");
		for(int i = 0; i < 14; i ++)
			q.dequeue();
        System.out.println("size: " + q.size());
        System.out.println("queue: " + q);
		System.out.println("peek: "+ q.peek());

//        System.out.println(Arrays.toString(q.arr));
    }

}
