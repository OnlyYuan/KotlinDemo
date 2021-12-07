package com.example.kotlindemo.utils.http

/**
 * retrofit 封装
 */
class RetrofitUtils private constructor() {

    companion object{
        fun getInstance() = SingletonHolder.holder
    }

    private object SingletonHolder {
        val holder = RetrofitUtils()
    }

    //用于普通请求的工具

    init {

    }

}