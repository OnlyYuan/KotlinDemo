package com.example.kotlindemo.leetcode

/**
 * 二叉搜索树
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 */
class BinarySearchTree {
    private val mList = ArrayList<Int>()
    private var mLow = 0
    private var mHigh = 0

    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
        mLow = low
        mHigh = high
        readValue(root)

        return 0
    }


   private fun readValue(root: TreeNode?){


    }




    inner class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}