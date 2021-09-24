package com.example.kotlindemo.leetcode.erfen;

/**
 * 153. 寻找旋转排序数组中的最小值
 */
public class FindMin {

    public int findMin(int[] nums) {

        int index = (nums.length-1)/2;
        int max = nums[0];
        //第一种情况，回到原始状态
        if (nums[0]<nums[nums.length-1]){
            return nums[0];
        }

        while(true){
           if (nums[index]<nums[index+1]){
               index = (index-1)/2;
           }

           if (nums[index]>nums[index+1]){
               return nums[index];
           }
        }

    }

}
