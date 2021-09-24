package com.example.kotlindemo.leetcode

import kotlin.math.max

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
class MuchNum {

    //1。hashmap法
    fun majorityElement(nums: IntArray): Int {

        val hashMap = HashMap<Int,Int>()
        var maxNum = nums[0]
        var maxCount = 0
        for ( element in nums){

            if (hashMap.containsKey(element)){
                var content = hashMap[element]
                if (content!!+1>maxCount){
                    maxNum = element
                }
                hashMap[element] = content!! + 1
                maxCount = Math.max(content!!+1,maxCount)
            }else{
                hashMap[element] = 1
            }
        }

        return maxNum
    }

    /**
     *  2.排序法 通过排序，看n/2的数字是谁，他就是结果
     */
    fun majorityElement2(nums: IntArray): Int {

        nums.sort()

        return  nums[nums.size/2]

    }

    fun minSpeedOnTime(dist: IntArray, hour: Double): Int {
        var maxSize =  dist.size
        for (element in dist){

        }
        return 0
    }

}