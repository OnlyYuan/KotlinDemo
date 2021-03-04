package com.example.kotlindemo.model.bean

/**
 * 识别接口返回error
 */
class WordErrorBackBean {

   var error:String
      get() {
          return error
      }
      set(value) {
          error =value
      }

    var error_description:String
        get() {
            return error
        }
        set(value) {
            error_description =value
        }


    override fun toString(): String {
        return "WordErrorBackBean(error='$error', error_description='$error_description')"
    }
}