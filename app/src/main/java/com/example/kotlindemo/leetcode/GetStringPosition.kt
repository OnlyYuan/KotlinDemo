package com.example.kotlindemo.leetcode

/**
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出
 * needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1
 */
class GetStringPosition {

    fun strStr(haystack: String, needle: String): Int {

        var hIndex = 0
        var nIndex = 0
        var hChars = haystack.toCharArray()
        var nChars = needle.toCharArray()

        if(needle ==""){
            return 0
        }

        for (i in hChars.indices){

             if (hChars[i] == nChars[nIndex]){
                 nIndex++
             }else{
                 nIndex = 0
             }

            if (nIndex == nChars.size)
            return i- nIndex
        }

        return -1
    }

}