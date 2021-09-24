package com.example.kotlindemo.leetcode.dongtaiduihua;

/**
 * 1137. 第 N 个泰波那契数
 * 泰波那契序列Tn定义如下：
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * 给你整数n，请返回第 n 个泰波那契数Tn 的值。
 *
 */
public class FibonacciN {

    public int tribonacci(int n) {

        if(n<2){
            return n ;
        }
        if (n==2){
            return 2;
        }

        int first = 0;
        int second = 1;
        int third = 1;
        int tent = 0;

        for (int i = 3;i<=n;i++){
            tent = first +second +third;
            first = second;
            second = third;
            third = tent;
        }

        return tent;
    }


}
