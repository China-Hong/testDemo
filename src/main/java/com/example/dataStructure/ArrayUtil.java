package com.example.dataStructure;

import java.lang.reflect.Constructor;

public class ArrayUtil {
    private String[] array;
    private volatile int length = 0;

    public ArrayUtil(Integer max) {
        array = new String[max];
    }

    public int contanis(String target){
        int index = -1;
        for(int i=0;i<array.length;i++){
            if(target.equals(array[i])){
                index=i;
                break;
            }
        }
        return index;
    }

    public int insert(String target){
          array[length]=target;
          length++;
          return length;
    }

    public boolean delete(String target){
        int index = 0;
        if((index=contanis(target))!=-1) {
            for (; index < array.length - 1; index++) {
                array[index] = array[index + 1];
                length--;
            }
            return true;
        }else{
            return false;
        }
    }

    public void display(){
        for(int i=0;i<length;i++){
            System.out.print(array[i]+"\t");
        }

    }

    public static void main(String[] args){
        try {
            //ArrayUtil arrayUtil = new ArrayUtil(2);
           Class clazz= Class.forName("com.example.dataStructure.ArrayUtil");
            Constructor cst = clazz.getConstructor(Integer.class);
            ArrayUtil arrayUtil = (ArrayUtil)cst.newInstance(2);

            arrayUtil.insert("hello");
            arrayUtil.insert("word");
            arrayUtil.delete("hello");
            arrayUtil.insert("123");
            arrayUtil.display();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
