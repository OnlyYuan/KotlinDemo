package com.example.kotlindemo.leetcode

/**
 *  盛最多水的容器
 */
class MaxWater {

    fun maxArea(height: IntArray): Int {
        var max = 0
        var left  = 0
        var right = height.size-1

        if (height.size<2){
            return 0
        }

        while (left != right){

            if (height[left]>height[right]){//right从最后往前移动
                max = Math.max(max,height[right]*(right-left))
                right --

            }else{//left从前往后移动
                max = Math.max(max,height[left]*(right-left))
                left ++
            }
        }

        return  max
    }

}