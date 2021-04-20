package com.example.kotlindemo.leetcode

/**
 * 移除元素
 *给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。元素的顺序可以改变。
 * 你不需要考虑数组中超出新长度后面的元素。*
 */
class RemoveE {

//    //1.普通双指针
//    fun removeElement(nums: IntArray, valNum: Int): Int {
//        var  count = 0
//
//        for( i  in nums.indices){
//            var mDelete = false
//            if ( nums[i] == valNum){//当等于规定值的时候
//                count++
//                mDelete = true
//            }
//
//            if (!mDelete ){
//                nums[i-count] = nums[i]
//            }
//        }
//        return nums.size-count
//    }

    /**首位双指针
     * 一个从开始进行对比left，一个从末尾开始right，
     * 当 left 等于valNm ,就将right的值赋值给left的位置，并向左移动一位
     */
    fun removeElement(nums: IntArray, valNum: Int): Int {

        var left  = 0
        var right = nums.size -1
        for ( i in nums.indices){

            if (nums[i] == valNum && right>i){
                for (j in right downTo 0){
                    if (nums[j]==valNum){
                        nums[j] = 0

                        right--
                    }else{
                        break
                    }
                }
                nums[i] = nums[right]
                nums[right] = 0
                right --
            }

        }

        return nums.size-1 - right
    }




}