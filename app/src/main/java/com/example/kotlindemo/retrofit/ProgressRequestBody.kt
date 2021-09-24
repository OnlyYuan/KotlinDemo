package com.example.kotlindemo.retrofit

import okhttp3.MediaType
import okhttp3.RequestBody
import okio.BufferedSink

/**
 * 用于显示进度的RequestBody
 */
class ProgressRequestBody: RequestBody() {

    var mRequestBody:RequestBody? = null
    var bufferedSink:BufferedSink? = null
    

    override fun contentType(): MediaType? {

        return null
    }

    override fun writeTo(sink: BufferedSink) {


    }


}