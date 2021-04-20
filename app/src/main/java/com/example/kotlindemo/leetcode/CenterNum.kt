package com.example.kotlindemo.leetcode

/**
 * 两个数组的中位数
 */
class CenterNum {

    /**
     * 1.暴力法： 先将两个数组合并，最后排序算法，最后算中位数
     *
     */
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {

        //nums1的下标计数
        var fCount = 0
        //nums2的下标计数
        var sCount = 0
        //合成数组的下标
        var index = 0

        var finalNums =  IntArray(nums1.size+nums2.size)

        var mSize = nums1.size
        var mCount1 = 0
        var mCount2 = 0
        //当nums1的计数值小于他的大小时
        if (nums1.size ==0){

            return getNum(nums2)
        }

        if (nums2.size ==0){

            return getNum(nums1)
        }


        while (fCount < mSize || sCount <nums2.size){

               if (sCount >=nums2.size){
                   mCount2 = nums2.size -1
               }

                if (fCount < mSize && (nums1[fCount] <= nums2[mCount2]|| sCount == nums2.size)  ){//当前nums1的值小，就将nums1的值放入到合成数列
                    finalNums[index] = nums1[fCount]
                    fCount++
                    index++
                    mCount1 = fCount
                }

                if (fCount >=mSize){
                    mCount1 = mSize -1
                }

               if (sCount <nums2.size && (nums1[mCount1]> nums2[sCount] || fCount == mSize)){//当前nums2的值小，就将nums2的值放入到合成数列
                    finalNums[index] = nums2[sCount]
                    index++
                    sCount++
                    mCount2 = sCount
                }
        }

        return getNum(finalNums)
    }


    /**
     * 计算中位数
     */
    private fun getNum(nums:IntArray):Double{

        var mNum = 0.0
        if (nums.size%2 == 0){ //偶数个
            mNum = (nums[nums.size/2]+nums[(nums.size/2)-1])/2.0
        }else{//基数个
            mNum = nums[(nums.size-1)/2].toDouble()

        }
        return  mNum
    }


}