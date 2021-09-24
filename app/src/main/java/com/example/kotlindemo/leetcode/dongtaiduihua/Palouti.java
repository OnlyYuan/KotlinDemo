package com.example.kotlindemo.leetcode.dongtaiduihua;


/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */

public class Palouti {

    public int climbStairs(int n) {
        if (n<2){
            return n;
        }

        int start = 0;
        int end = 1;
        int tent = 0;

        for (int i = 2; i<=n ; i++){
            tent = start +end;
            start = end;
            end = tent;
        }

        return tent;
    }

}
