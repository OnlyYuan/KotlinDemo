package com.example.kotlindemo.leetcode.dongtaiduihua;


/**
 *  509. 斐波那契数
 *  斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给你 n ，请计算 F(n)
 *
 */
public class Fibonacci {

    /** 暴力递归 ： O(n*n)
     * @param n
     * @return
     */
    public int fib(int n) {

        if (n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }

        return fib(n-1)+fib(n-2);
    }


    /**
     * 优化递归，采用 将前面的值保存利用，降低时间复杂度 O(n)
     * @param n
     * @return
     */
    public int fib1(int n) {

        if (n<2){
         return n;
        }

        int preNext = 0;
        int next = 1;
        int tent = 0;

        for (int i = 2; i<=n;i++){
            tent = next +preNext;
            preNext = next;
            next = tent;
        }

        return tent;
    }

}
