package com.example.kotlindemo.leetcode

import java.lang.StringBuilder

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时
 */


class ZChange {

    /**
     * 灵活使用 stringBuilder
     */
    fun convert(s: String, numRows: Int): String {

        var mChar = s.toCharArray()

        var rowList = ArrayList<StringBuffer>()

        for (i in 0 until numRows){
            rowList.add(StringBuffer())
        }

        var curRow = 0
        //向下时为true 向上为false
        var isDown = true
        if (numRows == 1){
            return s
        }

        for ( i in mChar.indices){
            //改变上下的情况
            if (curRow==0 && curRow==numRows-1){
                isDown = !isDown
            }
            rowList[curRow].append(mChar[i])
            if (isDown){
                curRow += 1
            }else{
                curRow -= 1
            }
        }

        var mString = StringBuilder()

        for(i in 0 until numRows){
            mString.append(rowList[i])
        }

        return  mString.toString()
    }

}