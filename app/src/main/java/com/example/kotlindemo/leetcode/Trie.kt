package com.example.kotlindemo.leetcode

/**
 * 前缀树
 */
class Trie() {

    /** Initialize your data structure here. */
    var mNode = TreeNode()

    inner class TreeNode(){
        var nodeValue = ""
        var isLast = false
        var childMap  = HashMap<String?,TreeNode?>()
    }


    /** Inserts a word into the trie. */
    fun insert(word: String) {

        var wordChars =  word.toCharArray()

        if (mNode.childMap[wordChars[0].toString()]==null ){//如果第一层为空，加入其中给你

            var firstDegreeNode = TreeNode()
            firstDegreeNode.nodeValue = wordChars[0].toString()
            mNode.childMap[wordChars[0].toString()] = firstDegreeNode
        }

        var currentNode :TreeNode? = mNode

        for ( i  in 1 until wordChars.size){

            if (currentNode?.childMap?.get(wordChars[i].toString()) ==null){//为空就创建一个

                var childNode:TreeNode? = TreeNode()
                childNode?.nodeValue = wordChars[i].toString()
                currentNode?.childMap?.set(wordChars[i].toString(), childNode)
            }else{
                currentNode = currentNode.childMap[wordChars[i].toString()]
            }
        }
        currentNode?.isLast = true
        //mNode =
    }



    /** Returns if the word is in the trie. */
    fun search(word: String): Boolean {

        val wordChars = word.toCharArray()
        for (i in 0 until wordChars.size){



        }

        return  true
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    fun startsWith(prefix: String): Boolean {

        return  true
    }

}
