package com.example.kotlindemo.leetcode;

import android.os.Looper;

import java.util.ArrayList;

/**
 * 两数之和
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 */
public class AddFun {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode mListNode = new ListNode();
        ListNode tentListNode = mListNode;
        //当前舍去10后的数字
        int tempValue = 0;
        int nextValue = 0;
        while (p1 != null || p2!= null||nextValue>0) {
            tempValue = ((p1==null)?0:p1.val) +((p2==null)?0:p2.val)+nextValue;
            nextValue = tempValue/10;
            tempValue = tempValue%10;

            tentListNode.next = new ListNode(tempValue);
            tentListNode = tentListNode.next;
            if (p1!=null){
                p1 = p1.next;
            }
            if (p2!=null){
                p2 = p2.next;
            }

        }

        return mListNode.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {

        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
