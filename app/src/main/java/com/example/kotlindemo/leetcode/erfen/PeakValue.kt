package com.example.kotlindemo.leetcode.erfen

/**
 * 162. 寻找峰值
 * 峰值元素是指其值严格大于左右相邻值的元素。
 * 给你一个整数数组nums，找到峰值元素并返回其索引。数组可能包含多个峰值，
 * 在这种情况下，返回 任何一个峰值 所在位置即可。你可以假设nums[-1] = nums[n] = -∞ 。你必须实现时间复杂度为 O(log n) 的算法来解决此问题。。
 */
class PeakValue {

    fun findPeakElement(nums: IntArray): Int {

        var index = (nums.size)/2
        var left = 0
        var right = nums.size
        var result = 0
        if(nums.size ==2){
            return if(nums[0]<nums[1])1 else 0
        }

        while (true){
            if (index-1<0 || index+1>nums.size-1){
                return index
            }else if (nums[index-1]<nums[index]&& nums[index]>nums[index+1]){
                return  index
            }else if (nums[index]>nums[index+1]){
                right = index
                index  = (left +index)/ 2
            }else if (nums[index]<nums[index+1]){
                left = index
                index = (index+right)/2
            }
        }
    }

}