package com.example.Algorithm.LinkedList;


public class LinkLst {

    /**
     * 链表反序
     * @param head
     * @return
     */
    public  Node reverseListNode(Node head){
        if(head == null){
              return head;
        }
          //前一个节点指针
          Node preNode = null;
          //当前节点指针
          Node curNode = head;
          //下一个节点指针
          Node nextNode = null;

          while(curNode != null){
              //将节点的next设置为前一个节点
              nextNode=curNode.getNext();
              curNode.setNext(preNode);
              //移动链表节点
              preNode=curNode;
              curNode=nextNode;
        }
          return preNode;
    }

    /**
     * 链表中环的检测(快慢指针实现)
     * @param args
     */
    public boolean hasLoop(Node node){
        //定义快慢指针
        if(node == null){
            return false;
        }

        Node p = node.getNext();
        Node q = node.getNext().getNext();

        while (q != null && q.getNext() != null) {
            p = p.getNext();
            q = q.getNext().getNext();

            //判断是否到链尾
            if(q == null){
                return false;
            }else if (p==q) {
                return true;
            }

        }

        return false;
    }

    /**
     * 两个有序链表合并
     * @param args
     */
    public Node mergeTwoList(Node headOne,Node headTwo){
        //如果两个链表都为空返回空
        if(headOne == null && headTwo == null){
            return null;
        }
        //第一个链表为空返回第二个链表
        if(headOne == null){
            return headTwo;
        }
        //第二个链表为空返回第一个链表
        if(headTwo == null){
            return headOne;
        }

        //判断链表数据的大小
        Node head = null;
        if(headOne.getData() > headTwo.getData()){
            head = headTwo;
            head.setNext(this.mergeTwoList(headOne, headTwo.getNext()));
        }else{
            head = headOne;
            head.setNext(this.mergeTwoList(headOne.getNext(),headTwo));
        }
        return head;
    }

    public static void main(String[] args){
        LinkLst linkLst = new LinkLst();
        //创建Node链表
        Node node3 = new Node(7);
        Node node2 = new Node(5,node3);
        Node node1 = new Node(3,node2);
        Node node = new Node(1,node1);

        Node curNode = node;
        //输出链表中数据
        System.out.println("链表反序前");
        while (true) {
            System.out.println(curNode.getData());
            curNode=curNode.getNext();
            if (curNode == null) {
              break;
            }
        }

        /*链表反转
        Node reNode = linkLst.reverseListNode(node);
        curNode=reNode;
        System.out.println("链表反序后");
        while (true) {
            System.out.println(curNode.getData());
            curNode=curNode.getNext();
            if (curNode == null) {
                break;
            }
        }

        //链表环
        //node.setNext(node2);
        Boolean lean = linkLst.hasLoop(reNode);
        System.out.println("是否存在环" + lean);
*/
        Node nodeThree = new Node(6);
        Node nodeTwo = new Node(4,nodeThree);
        Node nodeOne = new Node(2,nodeTwo);

        Node head = linkLst.mergeTwoList(node,nodeOne);
        System.out.println("合并两个有序链表");
        while (true) {
            System.out.println(head.getData());
            head=head.getNext();
            if (head == null) {
                break;
            }
        }

    }

}
