package com.example.kotlindemo.leetcode

import kotlin.math.abs
import kotlin.math.min

/**
 * 座位预约管理系统
 */
class SeatManager(n: Int) {
    var datas :BooleanArray = BooleanArray(n)

    init {
        for ( i in datas.indices){
            datas[i] = true
        }
    }

    fun reserve(): Int {
        for (i in datas.indices){
            if (datas[i]){
                datas[i] = false
                return i+1
            }
        }
        return 0
    }

    fun unreserve(seatNumber: Int) {
        datas[seatNumber-1] = true

    }

    fun closestRoom(rooms: Array<IntArray>, queries: Array<IntArray>): IntArray {
        var array = IntArray(queries.size)

        for (i in queries.indices){
            var min = 2147483647
            var index = 0
            var isBoolean = false
            for (j in rooms.indices){

                if (queries[i][1] <= rooms[j][1] ){
                    isBoolean = true
                    if (min > abs(rooms[j][0] - queries[i][0])){
                        min = abs(rooms[j][0] - queries[i][0])
                        index = rooms[j][0]
                    }else if (min == abs(rooms[j][0] - queries[i][0])){
                        index = Math.min(index,rooms[j][0])
                    }
                }
            }
            if (!isBoolean){
                index = -1
            }
            array[i] = index
        }


        return array
    }


}