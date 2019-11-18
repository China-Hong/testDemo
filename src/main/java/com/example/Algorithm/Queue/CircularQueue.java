package com.example.Algorithm.Queue;

public class CircularQueue {
    private int[] data;
    private int n;
    private int head = 0;
    private int tail = 0;

    public CircularQueue(int n) {
        this.n = n;
    }

    //入队
    private boolean enqueue(int item){
        //判断队列是否满，满了返回false
        if((tail+1)%n == head){
            return false;
        }
        data[tail] = n;
        tail = (tail+1)%n;
        return false;
    }

    //出队
    private int dequeue(){
        //判断队列是否为空
        if(tail == head){
            return -1;
        }
        int tmp = data[tail];
        head = (head+1)%n;
        return tmp;
    }
}
