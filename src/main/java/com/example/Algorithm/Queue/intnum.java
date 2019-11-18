package com.example.Algorithm.Queue;

public class intnum {

   public int getNum(int Num){
       int len = (Num+(Num%2)/2);
       if(Num==1){
           System.out.print("");
       }
        for(int i=1;i<len;i++){
           System.out.println(i+"+"+(Num-i));
           getNum(Num-i);
        }

        return Num-1;
    }


    public static void main(String[] args){
        intnum  intnum = new intnum();
        int num = 4;
        intnum.getNum(num);
        //intnum.getSumNumber(4,4);
    }
}
