 package com.example.kotlindemo.leetcode

/**
 * 整数转罗马数字
 */
class NumToLuoMa {

    var words = arrayOf(arrayOf("I","V","X"),arrayOf("X","L","C"),arrayOf("C","D","M"))

    fun intToRoman(num: Int): String {
        var data = ""
        var count  = 0
        var mNum = num

        while (num.toString().length>count-1){
          val m = mNum%10
          mNum /= 10
          if (count ==3){
              for ( i in 1..m){
                  data = "M$data"
              }
              break
            }
          data =  complain(m,count) + data
          count++
        }
        return data
    }


    private fun complain(num :Int,type:Int):String{
        var string = ""
        when(num) {
            in 1 until 4 -> {
                for (i in 1..num) {
                    string += words[type][0]
                }
            }

            4 -> {
                string = words[type][0] + words[type][1]
            }

            in 5 until 9 -> {
                string = words[type][1]
                for (i in 6..num) {
                    string += words[type][0]
                }
            }

            9 -> {
                string = words[type][0] + words[type][2]
            }
        }
        return string
    }


}