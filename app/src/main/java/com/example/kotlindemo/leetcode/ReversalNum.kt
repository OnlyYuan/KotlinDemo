package com.example.kotlindemo.leetcode

import android.util.Log

class ReversalNum {

    fun reverse(x: Int): Int {
        var num = 0
        var mx = x

        while (mx!= 0){
            var m = mx%10
            mx /= 10

            if (Int.MAX_VALUE/10<num|| Int.MIN_VALUE/10>num){
                Log.i("11","---->1")
                return 0
            }

            if ((Int.MIN_VALUE/10==num&&m>7 )|| (Int.MIN_VALUE/10==num&&m<-8)){
                Log.i("11","---->2")
                return 0
            }

            num = num*10 +m
        }

        return num
    }
}