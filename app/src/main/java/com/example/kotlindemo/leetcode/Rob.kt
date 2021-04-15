package com.example.kotlindemo.leetcode

import android.util.Log
import java.lang.reflect.Array
import java.util.*
import kotlin.math.max

/**
 * 抢劫问题(环形动态规划)
 * @author cpf
 */
class Rob {


    fun rob(nums: IntArray): Int {

        if (nums.isEmpty()){
            return 0
        }

        if (nums.size == 1)
            return nums[0]

        //抢第一个房间，就不抢最后一个
        var fNums = Arrays.copyOfRange(nums,0,nums.size-1)

        //不抢第一个房间，抢最后一个
        var lNums = Arrays.copyOfRange(nums,1,nums.size)


        var fNum = getMax(fNums)
        var lNum = getMax(lNums)
        Log.i("111","--->fNums:${fNum}  --->lNums:${lNum}")


        return max( fNum, lNum)
    }

    /**
     * 动态规划
     */
    private fun getMax(mNums:IntArray):Int{

        var currentNum = 0
        var tempNum = 0
        var preNum = 0

        for ( element in mNums){
            tempNum = currentNum
            currentNum = max(preNum,preNum+element)
            preNum = tempNum
        }

        return currentNum
    }


}