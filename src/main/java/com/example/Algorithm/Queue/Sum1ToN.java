package com.example.Algorithm.Queue;

import java.util.ArrayList;
import java.util.List;

public class Sum1ToN {

    private void print(List<Integer> list) {
        for (Integer k : list) {
            System.out.print(k + "+");
        }
    }

    private void f(int n, List<Integer> list, int start) {
        if (n == 1) {
            print(list);
            System.out.println(1);
        } else {
            for (int i = start; i <=n / 2; i++) {
                list.add(i);
                f(n - i, list, i);
                list.remove(list.size() -1);
            }
            print(list);
            System.out.println(n);

        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        new Sum1ToN().f(4,list, 1);
    }

}
