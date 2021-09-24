package com.example.kotlindemo.leetcode

import android.text.TextUtils.indexOf
import kotlin.math.max

/**
 * 回文
 */
class Palindrome {

    //1.中心扩散法
    fun longestPalindrome(s: String): String {

        var mChars = s.toCharArray()

        //是奇数
        var isOdd = false
        //最大长度
        var maxLen = 0
        //最大回文
        var maxString =""

        var left = 0
        var right = 0

        isOdd = mChars.size%2 != 0

        if (s==""){
            return ""
        }

        for ( i in mChars.indices){

            //基数状态，即以i为中心
            val lenth1 = getCurrentLen(mChars,i,i)
            val lenth2 = getCurrentLen(mChars,i,i+1)

            if (maxLen<Math.max(lenth1,lenth2)){
                maxLen = Math.max(lenth1,lenth2)
                if (lenth1>lenth2){
                    left = i - maxLen/2
                    right = i+ maxLen/2
                }else{
                    left = i - maxLen/2+1
                    right = i+ maxLen/2
                }
            }
        }
        return s.substring(left+1,right)
    }

    private fun getCurrentLen( chars: CharArray, mLeft:Int,mRight:Int):Int{
        var left = mLeft
        var right = mRight
        while (left>0 && right<chars.size && chars[left] == chars[right]){
            left--
            right++
        }

        return right-left+1
    }




}