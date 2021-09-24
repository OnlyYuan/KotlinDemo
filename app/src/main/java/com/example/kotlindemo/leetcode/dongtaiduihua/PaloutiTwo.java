package com.example.kotlindemo.leetcode.dongtaiduihua;


/**
 * 746. 使用最小花费爬楼梯
 *
 * 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。
 * 每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。
 * 请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶
 *
 */

public class PaloutiTwo {

     /**注意 楼顶在数组外。。。即最后一步要走到cost.length+1的位置**/
    public int minCostClimbingStairs(int[] cost) {

        if (cost.length==1){
            return cost[0];
        }
        if (cost.length ==2){
            return Math.min(cost[0],cost[1]);
        }

        int preOne = 0;
        int preTwo = 0;
        int tent = 0;

        for (int i = 2;i<=cost.length;i++){
            tent = Math.min(preOne+cost[i-1],preTwo+cost[i-2]);
            preTwo = preOne;
            preOne = tent;
        }

        return preOne;
    }
}
