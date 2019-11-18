package com.example.Algorithm.Stack;

import com.example.Algorithm.LinkedList.Node;

public class LinkStack{
    private Node head;
    private Node tail;
    private int count;
    private int n;

    public LinkStack(int n) {
        this.count=0;
        this.n = n;
    }

    //入栈
    public boolean push(int item){
        //判断栈是否满
        if(count == n){
            return false;
        }
        Node node = new Node(item);
        if(count == 0){
            head = node;
            tail = node;
        }else{
            node.setNext(head);
            head=node;
        }
        count++;
        return true;
    }

    //出栈
    public int pop(){
        //判断栈是否满
        if(count == 0){
            return -1;
        }
        //出栈
        int tmp = head.getData();
        head = head.getNext();
        count--;
        return tmp;
    }

    public static void main (String[] args){
        LinkStack stack = new LinkStack(3);
        System.out.println(stack.pop());
        System.out.println(stack.push(1));
        System.out.println(stack.push(2));
        System.out.println(stack.push(3));
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.push(4));
    }
}
