package com.example.kotlindemo.leetcode

/**
 * 青蛙过河
 */
class FrogRiver {
    var index = 0
    var size = 0
    var cur = 0
    lateinit var mStones :IntArray
    var hashMap = HashMap<Int,Int>()

    fun canCross(stones: IntArray): Boolean {

        mStones = stones
        size = stones.size
        for (i in stones.indices){
            hashMap.put(stones[i],i)
        }
        cur = stones[0]
        nextStep(1)
        stones
        return false
    }

    /**
     * 下一步
     */
   private fun nextStep(k:Int):Boolean{
        index += k
        if (index == mStones[mStones.size-1]){
            return true
        }else if ( index< size && hashMap.containsKey(cur+index)){
            cur += index
        }else{
            return false
        }

        nextStep(k-1)
        nextStep(k+1)
        nextStep(k)

        return false
    }

}