package com.example.kotlindemo.leetcode

/**
 *给定一个整数数组 nums 和一个整数目标值 target，
 * 请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。你可以按任意顺序返回答案。
 * 加法 （hashMap）
 */
class Sum {

        //时间复杂度 O(n*n) 暴力匹配   空间复杂度 O(1)
//        fun twoSum1(nums: IntArray, target: Int): IntArray {
//            for(i in nums.indices){
//
//              for (j in i+1 until nums.size){
//                 if (target == nums[i]+nums[j]){
//                     return intArrayOf(i,j)
//                 }
//              }
//            }
//            return intArrayOf(0,0)
//        }

    //采用hashMap的方式，时间复杂度（O(n)），用当前位置的值去和hashMap中查
     var map = HashMap<Int,Int>()
     fun twoSum(nums: IntArray, target: Int): IntArray {
      for (i in nums.indices){
         if (map.containsKey(target-nums[i]))    {
             return intArrayOf(map.get(target-nums[i])!!,i)
         }else{
             map.put(nums[i],i)

         }
      }
         return intArrayOf(0,0)
     }


 }

