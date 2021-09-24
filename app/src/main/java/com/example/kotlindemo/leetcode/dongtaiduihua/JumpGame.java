package com.example.kotlindemo.leetcode.dongtaiduihua;

/**
 * 55. 跳跃游戏
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 */
public class JumpGame {

    public boolean canJump(int[] nums) {

        int mCount = 0;
        if(nums.length ==1){
            return true;
        }

        if(nums[0]==0){
            return false;
        }

        for (int i = 0;i<nums.length-1;i++){

            mCount = Math.max(mCount-1,nums[i]);
            if(mCount<=0){
                return false;
            }
        }

        return true;
    }
}
