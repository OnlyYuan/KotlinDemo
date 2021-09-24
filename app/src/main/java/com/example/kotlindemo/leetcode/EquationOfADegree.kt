package com.example.kotlindemo.leetcode

import android.util.Log
import org.w3c.dom.CharacterData
import java.text.CharacterIterator

/**
 * 一元一次方程
 */
class EquationOfADegree {

    fun getData(equation:String):Int{

        //普通值
        var mNumData = 0

        //带有未知数的值
        var xData = 0

        val mEquation = equation.replace(" ","")
        val mfEquation = equation.replace("-","+-")

        val mStrings = mfEquation.split("=")

        val leftString = mStrings[0]
        val rightString = mStrings[1]

        val mLeftStrings = leftString.split("+")
        val mRightStrings = rightString.split("+")

        for (element in mLeftStrings){


            if ( element.isNotEmpty() &&Character.isLowerCase(element.substring((element.length -1)).toCharArray()[0])){//判断是不是含有未知数

                if (element.length ==1){//如果为a
                    xData += 1

                } else if (element.length ==2 && element[0]=='-'){//为-a
                    xData -=1
                }else{
                    xData += element.substring(0,element.length -1).toInt()
                }

            }else{//数字
                if (element.isNotEmpty())
                mNumData -= (element.toInt())
            }
        }

        for (element in mRightStrings){
            if (element.isNotEmpty() &&Character.isLowerCase( element.substring((element.length -1)).toCharArray()[0])){//判断是不是含有未知数
                if (element.length ==1){//如果为a
                    xData -= 1

                } else if (element.length ==2 && element[0]=='-'){//为-a
                    xData +=1
                }else{
                    xData -= element.substring(0,element.length -1).toInt()
                }

            }else{//数字
                if (element.isNotEmpty())
                mNumData += (element.toInt())
            }
        }

        Log.i("11","---->leftString：$leftString  ----->right:$rightString")

        return mNumData/xData
    }


}