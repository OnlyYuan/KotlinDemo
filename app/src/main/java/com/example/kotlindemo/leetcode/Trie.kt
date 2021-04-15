package com.example.kotlindemo.leetcode

import android.util.Log
import org.w3c.dom.Node

/**
 * 前缀树
 */
class Trie() {

    /** Initialize your data structure here. */
    private var mNode = TreeNode()

    inner class TreeNode() {
        var nodeValue = ""
        var isLast = false
        var childMap = HashMap<String?, TreeNode?>()
    }


    /** Inserts a word into the trie. */
    fun insert(word: String) {
        mInsert(word)
    }

    //添加结点的过程既是添加结点的作用也是匹配前缀的过程
    private  fun  mInsert( str:String?)
    {
        if (str == null || str.isEmpty()) return
        var chars = str.toCharArray ()
        var currentNode = mNode
        for (i in chars.indices) {
            //不包含当前字符加入
            if (!currentNode.childMap.containsKey(chars[i].toString())) {
                var node = TreeNode()
                node.nodeValue = chars[i].toString()
                currentNode.childMap[chars[i].toString()] = node
            }

            currentNode = currentNode.childMap[chars[i].toString()]!!;
        }
        if (!currentNode.isLast)
            currentNode.isLast = true
    }



    /** Returns if the word is in the trie. */
    fun search(word: String?): Boolean {
        if (word == null || word.isEmpty()) {
            return false
        }
        val wordChars = word.toCharArray()
        var currentNode: TreeNode? = mNode

        for (element in wordChars) {
            if (currentNode?.childMap?.contains(element.toString())!!) {//包含当前元素
                currentNode = currentNode.childMap[element.toString()]

            } else {//不包含的时候，直接返回
                return false
            }
        }

        return currentNode!!.isLast
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    fun startsWith(prefix: String?): Boolean {
        if (prefix == null || prefix.isEmpty()) {
            return false
        }

        val wordChars = prefix.toCharArray()
        var currentNode: TreeNode? = mNode

        for (element in wordChars) {
            if (currentNode?.childMap?.contains(element.toString())!!) {//包含当前元素
                currentNode = currentNode.childMap[element.toString()]

            } else {//不包含的时候，直接返回
                return false
            }
        }

        return true
    }


    /**
     * 输出前缀树
     */
    private fun outputTree(treeNode: TreeNode) {

        Log.i("111", "-->nodeValue:${treeNode.nodeValue}  -->是否是结束： ${treeNode.isLast}")
        treeNode.childMap.forEach {
            it.key
            it.value?.let { it1 -> outputTree(it1) }

        }

    }

    /**
     * 对外输出口
     */
    public fun outputTree() {

        outputTree(mNode)
    }

    /**
     * java 固定数组大小的简单方法
     */
//    class Trie {
//        private Trie[] children;
//        private boolean isEnd;
//
//        public Trie() {
//            children = new Trie[26];
//            isEnd = false;
//        }
//
//        public void insert(String word) {
//            Trie node = this;
//            for (int i = 0; i < word.length(); i++) {
//                char ch = word.charAt(i);
//                int index = ch - 'a';
//                if (node.children[index] == null) {
//                    node.children[index] = new Trie();
//                }
//                node = node.children[index];
//            }
//            node.isEnd = true;
//        }
//
//        public boolean search(String word) {
//            Trie node = searchPrefix(word);
//            return node != null && node.isEnd;
//        }
//
//        public boolean startsWith(String prefix) {
//            return searchPrefix(prefix) != null;
//        }
//
//        private Trie searchPrefix(String prefix) {
//            Trie node = this;
//            for (int i = 0; i < prefix.length(); i++) {
//                char ch = prefix.charAt(i);
//                int index = ch - 'a';
//                if (node.children[index] == null) {
//                    return null;
//                }
//                node = node.children[index];
//            }
//            return node;
//        }
//    }




}