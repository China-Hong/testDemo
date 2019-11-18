package com.example.Algorithm.Stack;

public class ArrayStack {
    private String[] items;
    private int n;
    private int count;

    public ArrayStack(int n) {
        items = new String[n];
        count = 0;
        this.n = n;
    }
    //入栈
    public boolean push(String item){
        //判断栈是否满
        if(count == n){
            return false;
        }
        //入栈
        items[count] = item;
        count++;
        return true;
    }

    //出栈
    public String pop(){
        if(count == 0){
            return null;
        }
        //弹出栈顶元素
        String tmp = items[count-1];
        count--;
        return tmp;
    }

    public static void main(String[] args){
        ArrayStack stack = new ArrayStack(3);
        System.out.println(stack.push("1"));
        System.out.println(stack.push("2"));
        System.out.println(stack.push("3"));
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.push("4"));
    }
}
