package com.example.kotlindemo.leetcode.dongtaiduihua;


/**
 * 198.打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 */
public class RaidPlunder {

    //转移公式    num = max ( preFirst +dp[i-1],preSecond +dp[i-2])
    public int rob(int[] nums) {

        if (nums.length ==1){
            return nums[0];
        }

        if (nums.length ==2){
            return Math.max(nums[0],nums[1]);
        }

        int preFirst = Math.max(nums[0],nums[1]);
        int preSecond = nums[0];
        int maxNum = 0;
        for (int i = 2; i<nums.length;i++){
            maxNum = Math.max(preFirst ,preSecond+nums[i]);
            preSecond = preFirst;
            preFirst = maxNum;
        }

        return maxNum;
    }

}
