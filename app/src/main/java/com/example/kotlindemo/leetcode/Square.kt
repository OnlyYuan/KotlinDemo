package com.example.kotlindemo.leetcode

import kotlin.math.sqrt

class Square {

    fun judgeSquareSum(c: Int): Boolean {

        var cur = 0.0
        while (cur*cur <= c ){
            var tent = c - cur*cur
            var m = Math.sqrt(tent)

            if ( m == (m.toInt()).toDouble() ){
                return true
            }
            cur++
        }
        return false
    }


}