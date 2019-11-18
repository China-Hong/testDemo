package com.example.Lumba;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;

public class LumbaList {
    public static  void main(String []args) throws Exception{
        //List遍历
        String[] atp = {"Rafael Nadal","Novak Djokovic", "Stanislas Wawrinka",
                "David Ferrer","Roger Federer","Andy Murray","Tomas Berdych","Juan Martin Del Potro"};
        List<String> players= Arrays.asList(atp);
        players.forEach( (player) -> System.out.println(player+";"));
        players.forEach(System.out::print);

        //排序求和
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
        list.stream().map((n) -> n*n).forEach(System.out::println);
        int sum = list.stream().map((n) -> n*n).reduce((a,b) -> a+b).get();
        System.out.println(sum);

       Class clz =  Class.forName("com.example.Algorithm.Queue.ArrayQueue");
       Constructor arryConstructor = clz.getConstructor();
       Object arrayQueue =  arryConstructor.newInstance();
    }
}
