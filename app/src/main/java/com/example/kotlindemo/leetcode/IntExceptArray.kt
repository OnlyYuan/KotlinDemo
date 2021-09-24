package com.example.kotlindemo.leetcode

/**
 * 给你一个由 无重复 正整数组成的集合 nums ，
 * 请你找出并返回其中最大的整除子集 answer ，
 * 子集中每一元素对 (answer[i], answer[j]) 都应当满足：answer[i] % answer[j] == 0 ，
 * 或answer[j] % answer[i] == 0如果存在多个有效解子集，返回其中任何一个均可。
 *
 *
 */
class IntExceptArray {

    fun largestDivisibleSubset(nums: IntArray): List<Int> {
        val mList = ArrayList<Int>()
        /**
         *  转移条件：1. 当前数是集合中最大数的公倍数  2.当前数是集合中最小数的公倍数
         */
        var mNums = nums
        var isTrue = false
        mNums.sort()
        var tentList = ArrayList<Int>()
        for ( i in nums.indices){
            var max = 1
            var min = 1

            for ( j in i until nums.size){

                if ( mNums[j]%max ==0 || min%mNums[j] == 0){
                    tentList.add(nums[j])
                    isTrue = true
                }else{
                    isTrue = false
                }

                if (max < mNums[j]&&isTrue){
                    max = mNums[j]
                }

                if (min >nums[j]&&isTrue){
                    min = nums[j]
                }
            }

            if (tentList.size>mList.size){
                mList.clear()
                mList.addAll(tentList)
            }
            tentList.clear()
        }

        return mList
    }

}