package com.example.Algorithm.Queue;

import com.example.Algorithm.LinkedList.Node;

public class LinkQueue {
    private Node head;
    private Node tail;


    //入队操作
    public boolean enqueue(int item){
        //入队操作
        Node node = new Node(item);
        if(tail == null){
            head=node;
            tail=node;
        }else{
            tail.setNext(node);
            tail=node;
        }
        return true;
    }
    //出队操作
    public int dequeue(){
        //出队操作
        if(head == null){
            return -1;
        }
        int tmp = head.getData();
        head = head.getNext();
        //如果到链尾则初始化队列
        if(head == null){
            tail = null;
        }
        return tmp;
    }
}
