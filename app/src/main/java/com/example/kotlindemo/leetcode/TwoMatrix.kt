package com.example.kotlindemo.leetcode

/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。
 * 该矩阵具有以下特性：每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 */

class TwoMatrix {

    /**
     *  1. 从右上开始查找
     */

    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {

        var verticalNum = 0
        var horizontalNum  = matrix[0].size-1
        while (verticalNum<matrix.size && horizontalNum>-1){
            if (matrix[verticalNum][horizontalNum] == target){
                return true
            }else if (matrix[verticalNum][horizontalNum]>target){
                horizontalNum --
            }else{
                verticalNum ++
            }

        }

        return  false
    }


    /**
     * 2.从左下角开始搜索
     */


    /**
     * 3.暴力解法
     */
}