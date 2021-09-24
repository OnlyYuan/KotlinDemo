package com.example.kotlindemo.leetcode

/**
 * 给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
 * 子数组大小 至少为 2 ，且子数组元素总和为 k 的倍数。如果存在，返回 true ；否则，返回 false 。
 * 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数
 */
class ContinuitySum {

    fun checkSubarraySum(nums: IntArray, k: Int): Boolean {

        /**
         * 计算前缀和 除以k的余数，因为结果相同那么前缀的余数也相等，且满足 两个下标的差大于2
         */
        val hashMap = HashMap<Int,Int>()
        var tent = 0
        if (nums.size<2){
            return false
        }

        for (i in nums.indices){
            tent += nums[i]
            var mContent = tent%k
            if (mContent ==0){
                return true
            }

            if (hashMap.containsValue(mContent)){
                return true
            }else{
                hashMap[i] = mContent
            }
        }

        return false
    }


}