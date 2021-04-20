package com.example.kotlindemo.leetcode

import android.util.Log
import kotlin.math.max

/**
 * 求最大的不重复的字符串
 * @author cpf
 */
class MaxChildString {

//    /**
//     * 方法一：暴力算法，先找出元素最大个数，然后再最大开始分割查询，如果没有重复就返回大小，如果都有重复，
//     * 就进入循环 max--
//     */
//    var map = HashMap<String,Int>()
//    fun lengthOfLongestSubstring(s: String): Int {
//
//        if (s==null||s==""){
//
//            return 0
//        }
//
//        val sChars = s.toCharArray()
//        val mSize =  getNum(s)
//
//        if (sChars.size ==1){
//            return 1
//        }
//
//        Log.i("11","-->mSize${mSize}")
//        for (i in mSize-1 downTo 0){
//
//            for ( j in  0 until sChars.size-i){
//                var  mMap = HashMap<String,Int>()
//                var mString = s.substring(IntRange(j,j+i))
//                Log.i("11","---> i${i} -->${j+i} mString:${mString}")
//                var mChars = mString.toCharArray()
//
//                for (k in mChars.indices){
//                    if (!mMap.containsKey(mChars[k].toString())){
//                        mMap.set(mChars[k].toString(),k)
//                    }
//                }
//
//                if (mMap.size == i+1){
//                    Log.i("111","--->最大：${mMap.size}")
//                    return i+1
//                }
//            }
//
//        }
//
//        return 0
//    }
//
//    //计算不同元素的个数
//    private fun getNum(s: String):Int{
//        val chars = s.toCharArray()
//        for (i in chars.indices){
//            if (!map.containsKey(chars[i].toString())){
//                map.set(chars[i].toString(),i)
//            }
//        }
//        return map.size
//    }

//    //2.划玻璃法(假)
//    fun lengthOfLongestSubstring(s: String): Int {
//
//        if (s==""){
//            return 0
//        }
//
//        val mChars = s.toCharArray()
//        var size = 0
//
//        if (mChars.size ==1){
//            return 1
//        }
//
//        for (i in mChars.indices){
//            var hashSet = HashSet<String>()
//            var mCount = 0
//            loop@for (j in i until mChars.size){
//                if (hashSet.add(mChars[j].toString())){
//                    mCount ++
//                }else{
//                    size = Math.max(size,mCount)
//                    break@loop
//                }
//            }
//            if (mCount > size){
//                size = mCount
//            }
//        }
//        return size
//    }


    //3.hashSet
    fun lengthOfLongestSubstring(s: String): Int {
        var hashSet = HashSet<Char>()
        //左边下标
        var left = 0
        //右边下标
        var right = 0

        var num = 0
       // var mChars = s.toCharArray()

        for ( i in s.indices){
            hashSet.remove(s[i])
             while (left < s.length && !(hashSet.contains(s[left]))){

                hashSet.add(s[left])
                left++
            }

            num = max(num,left -i)

        }

            return  num
    }


}