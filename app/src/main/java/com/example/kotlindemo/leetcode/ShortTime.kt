package com.example.kotlindemo.leetcode

import android.util.Log

/**
 * 给你一个整数数组 jobs ，其中 jobs[i] 是完成第 i 项工作要花费的时间。
 * 请你将这些工作分配给 k 位工人。所有工作都应该分配给工人，
 * 且每项工作只能分配给一位工人。工人的 工作时间 是完成分配给他们的所有工作花费时间的总和。
 * 请你设计一套最佳的工作分配方案，使工人的 最大工作时间 得以 最小化 。返回分配方案中尽可能 最小 的 最大工作时间 。
 */
class ShortTime {

    fun minimumTimeRequired(jobs: IntArray, k: Int): Int {

        jobs.sort()
        for ( e in jobs)
        Log.i("11","-->${e}")

        var minMax = 2147483647
        for ( i in jobs.indices){
            //minMax = Math.min(minMax,

        }


        return 0
    }
}