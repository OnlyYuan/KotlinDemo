package com.example.kotlindemo.leetcode

/**
 * 回文数
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是
 */
class PalindromeNum {
    fun isPalindrome(x: Int): Boolean {
        var left = x
        var right = 0

        if(x<0)
        return false

        if(x!=0 && x%10 == 0){
            return false
        }

        while (left>right){
            right = left%10 +right*10
            left /= 10
        }
        if(right == left || left == right/10){
            return true
        }

        return false
    }
}