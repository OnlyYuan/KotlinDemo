package com.example.kotlindemo.leetcode

import java.util.*
import kotlin.math.max

/**
 * 84. 柱状图中最大的矩形
 *给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */
class LargestRectangle {


    fun largestRectangleArea(heights: IntArray): Int {
        val size = heights.size+2

        val mHeights = arrayOfNulls<Int>(size)
        mHeights[0] = 0
        for (i in heights.indices){
            mHeights[i+1] = heights[i]
        }
        //添加一个末尾哨兵
        mHeights[size-1] = 0

        //单调栈
        var stack = Stack<Int>()
        var index = 0
        var maxArea = 0
        var popTop = 0

        while (index<mHeights.size){
            while ( !stack.isEmpty() && mHeights[stack.peek()]!!>mHeights[index]!!){
                var mOut =  stack.pop()
                popTop =  stack.peek()
                maxArea = max(maxArea,(index-popTop-1)*mHeights[mOut]!!)
            }

            if (stack.isEmpty() || mHeights[stack.peek()]!! <= mHeights[index]!!){
                stack.push(index)
            }
            index++
        }
        return maxArea
    }

}