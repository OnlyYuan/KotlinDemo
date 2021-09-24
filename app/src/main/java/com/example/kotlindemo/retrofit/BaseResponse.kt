package com.example.kotlindemo.retrofit

/**
 * 返回结构
 *{
"code": 200,
"message": "成功",
"content": {
...
}
 */
data class BaseResponse <T>(
        private var code: Int = 0,
        private var messgae:String = "",
        private var content:T? = null
){



}