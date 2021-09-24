package com.example.kotlindemo.leetcode

/**
 * 整除（不使用乘除法和mod运算）
 */
class Divide {

    fun divide(dividend: Int, divisor: Int): Int {

        var mDividend = dividend
        var mDivisor = divisor
        var isSign = 1
        var result = 0
        if (dividend==0){
            return 0
        }

        if (dividend<0){
            mDividend = Math.abs(dividend)
            isSign *=-1
        }
        if (divisor<0){
            mDivisor = Math.abs(divisor)
            isSign *=-1
        }

        while ( mDividend >= mDivisor ){
            mDividend -= mDivisor
            result ++
        }

        return result*isSign
    }

}