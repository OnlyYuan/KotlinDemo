package com.example.kotlindemo.leetcode

/**
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出
 * needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1
 *
 * 都自带有kmp算法  haystack.indexOf(needle)
 */
class GetStringPosition {

    //1.暴力解法，循环匹配，为了减小循环次数，在匹配失败的情况下，直接进入下次循环
    fun strStr1(haystack: String, needle: String): Int {

        var hIndex = 0
        var nIndex = 0
        var hChars = haystack.toCharArray()
        var nChars = needle.toCharArray()

        if(needle ==""){
            return 0
        }
        haystack.indexOf(needle)
        while (hIndex<hChars.size){

             if (hChars[hIndex] == nChars[nIndex]){
                 hIndex++
                 nIndex++
             }else{
                 hIndex = hIndex - nIndex+1
                 nIndex = 0
             }

            if (nIndex == nChars.size)
            return hIndex- nIndex
        }

        return -1
    }


    //2.kmp
    fun strStr(haystack: String, needle: String): Int {
        if (needle ==""){
            return 0
        }

        var next = getMaxValue(needle)
        val mDatas = haystack.toCharArray()
        val mNeedle = needle.toCharArray()
        var index = 0
        var i = 0

        while (i <mDatas.size && index < needle.length){
            if (index ==-1||mDatas[i] == mNeedle[index]){
                    index ++
            }else{
                index = next[index]
            }
            if (index == needle.length){
                return i-index
            }
        }

        return -1
    }


    /**
     * 生成 前缀和后缀的最大值
     */
  private  fun  getMaxValue( needle: String ):IntArray{
        var mChars = needle.toCharArray()
        var next = IntArray(mChars.size)
        next[0] = -1
        //主字符数组下标
        var i = 0
        //做为目标数组下标（从-1开始）
        var j = -1

        while ( i< mChars.size ){
            //如果当前主体和目标相等，则或者到当前next的值
            if (j == -1 || mChars[i] == mChars[j]){
                j++
                i++
                next[i] = j
            }else{
                j = next[j]
            }
        }

        return next
    }



}
