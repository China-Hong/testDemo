package com.example.codeTest;

import java.util.ArrayList;

class ListNode {
        int val;
        ListNode next = null;

                ListNode(int val) {
            this.val = val;
        }
    }
public class nodeArrary {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
          ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        ListNode temp = listNode;
        while ( temp != null ) {
            list.add( temp.val );
            temp = temp.next;
        }
        for ( int i = list.size()-1; i>=0; i-- ) {
            result.add( list.get(i) );
        }
        return result;
    }

    public static void main(String[] args) {
        nodeArrary nodeArrary = new nodeArrary();
        ListNode node = new ListNode(1);
        ListNode nodetwo = new ListNode(2);
        ListNode nodethree = new ListNode(3);
        node.next=nodetwo;
        nodetwo.next=nodethree;
        ArrayList<Integer> array = nodeArrary.printListFromTailToHead(node);
        System.out.println(array.toString());
    }


}
