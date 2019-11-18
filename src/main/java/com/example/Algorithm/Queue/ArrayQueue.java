package com.example.Algorithm.Queue;

public class ArrayQueue {
    private int[] date;
    private int n;
    private int head = 0;
    private int tail = 0;

    public ArrayQueue(int n) {
        this.date = new int[n];
        this.n = n;
    }

    //队列入队操作
    public boolean enqueue(int item){
        //判断队列是否满
        if(tail == n){
            //如果队列头从0开始则返回false
            if(head == 0){
                return false;
            }
            //如果队列不为0，则开始循环移动数组
            for(int i = head ;i<tail ;i++){
                date[i-head]=date[i];
            }
            //将队列头设为0，尾设为tail-head
            head = 0;
            tail = tail - head;
        }
        //入队
        date[tail] = item;
        tail++;
        return true;
    }

    //队列出队操作
    public int dequnue(){
        //判断队列是否空
        if(head == tail){
            return -1;
        }
        //出队操作
        int tmp = date[head];
        head++;
        return tmp;
    }
}
