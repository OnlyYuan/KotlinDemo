package com.example.kotlindemo.leetcode.linklist;

/**
 * 92. 反转链表 II
 * 给你单链表的头指针 head 和两个整数left 和 right ，其中left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 */

public class OverReturnByLeftRight {


    /**
     * 头插法
     */

    public ListNode reverseBetween(ListNode head, int left, int right) {

        //先设置一个链表
        ListNode normalNode = new ListNode(0);

        normalNode.next = head;
        //表示left前面一个节点：（left部位0的话）
        ListNode mNode = normalNode;
        //表示left第一个点
        ListNode pointNode =  normalNode.next;

        //找到mNode 和pointNode
        for (int i = 0 ;i<left-1;i++){
            mNode = mNode.next;
            pointNode = pointNode.next;
        }

        for (int i=0; i<right-left;i++){
            ListNode delete = pointNode.next;
            //1.先将移动point的next
            pointNode.next = delete.next;
            //2.再将头插的节点next存入
            delete.next = mNode.next;
            //3、最后拼接上mNode
            mNode.next = delete;
        }

     return  normalNode.next;
    }


    //暴力硬拆
    public ListNode reverseBetween2(ListNode head, int left, int right) {
        //先设置一个链表
        ListNode normalNode = new ListNode(0);
        normalNode.next = head;
        ListNode leftNode = normalNode;

        for (int i = 0 ;i<left-1;i++){
            leftNode = leftNode.next;
        }



        return null;
    }

}


class ListNode {

      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }