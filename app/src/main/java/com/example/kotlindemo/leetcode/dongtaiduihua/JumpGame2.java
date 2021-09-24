package com.example.kotlindemo.leetcode.dongtaiduihua;

/**
 * 45. 跳跃游戏 II
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *假设你总是可以到达数组的最后一个位置。
 */
public class JumpGame2 {

    public int jump(int[] nums) {
        int  mValue = nums[0];
        int  maxIndex = 0;
        int  mCount = 0;

        for (int i = 0;i<nums.length;i++){

            if(mValue ==0||i!=nums.length-1){
                i= maxIndex;
                mValue = nums[i];
                mCount ++;
            }

            if (nums[i]>mValue){
                maxIndex = i;
            }
            mValue--;
        }
        return mCount;
    }

}
