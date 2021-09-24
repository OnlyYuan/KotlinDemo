package com.example.kotlindemo.leetcode

import android.app.Instrumentation
import kotlin.math.max

/**
 * 合并数组
 */
class CombineArray {

    /**
     * 1.逆向双指针，从末尾大排到小
     */
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {

        //数组nums1的下标
        var index1 = m -1
        //数组nums2的下标
        var index2 = n-1
        var count = nums1.size -1

        if (m == 0){
            for (i in nums2.indices){
                nums1[i] =nums2[i]
            }
            return
        }
        if (n==0){
            return
        }

        while (index2>-1){
            if (index1>-1&&nums1[index1]>nums2[index2]){
                nums1[count] = nums1[index1]
                index1--
            }else{
                nums1[count] = nums2[index2]
                index2 --
            }
             count--
        }
    }

    /**
     * 2.暴力法：合并后后直接排序
     */


    //中心扩散法
    fun longestPalindrome(s: String): String {

        var mChars = s.toCharArray()
        //最大长度
        var maxLength = 0
        var index = 0
        //最大字符串
        var maxString =""

        if (s.length ==1 ){
            return s
        }

        if (s.isEmpty()){
            return ""
        }

        while (index<mChars.size){
            //基数
            var s1 = getString(s,index,index)
            //偶数
            var s2= getString(s,index,index+1)
            max(s1.length,s2.length)


            index++
        }


        return ""
    }


    fun getString( s:String,left:Int,right:Int):String{
        var mLeft = left
        var mRight = right

        var mChars = s.toCharArray()
        while (mLeft<0||mRight>mChars.size){
            if (mChars[mLeft] !=mChars[mRight]){
                return s.substring(mLeft,mRight+1)
            }

            mLeft--
            mRight++
        }

        return s
    }


}