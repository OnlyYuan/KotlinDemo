package com.example.kotlindemo.leetcode

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 */
class BinaryBuilder {

    var temp = Long.MIN_VALUE

    class TreeNode(var `val`: Int) {
             var left: TreeNode? = null
             var right: TreeNode? = null
         }


    fun isValidBST(root: TreeNode?): Boolean {

       // ergodic(root)

        return   ergodic(root)
    }

   private fun ergodic(root: TreeNode?):Boolean{
        var l = true
        var r = true
        root?.left?.let {  l =ergodic(it) }
        if (temp>=root!!.`val`){
            return false
        }
        temp = root.`val`.toLong()
        root.right?.let {  r =ergodic(it)}

        return  l && r
    }


     fun initData(m:IntArray):Boolean{
        var treeNode = TreeNode(m[0])
        treeNode.left = TreeNode(m[1])
        treeNode.right = TreeNode(m[2])

       return isValidBST(treeNode)
    }

}