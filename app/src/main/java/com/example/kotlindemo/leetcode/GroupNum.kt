package com.example.kotlindemo.leetcode

class GroupNum {
    fun numberOfMatches(n: Int): Int {
        var temp = n
        var count = 0
        while (temp>1){
            if (temp%2 ==0){//偶数
                temp /= 2
                count += temp
            }else{//奇数
                temp = (temp+1)/2
                count += temp-1
            }
        }

        return count
    }


    fun minPartitions(n: String): Int {
        var mChars = n.toCharArray()
        var max = '0'
        for (e in mChars){
            if (max<e) {
                max = e
            }
        }
        return max.toString().toInt()
    }

    fun stoneGameVII(stones: IntArray): Int {
        var list = ArrayList<Int>()
        var max = 0
        for ( e in stones){
            list.add(e)
            max += e
        }

        var cur = list.size

        return  0
    }







}