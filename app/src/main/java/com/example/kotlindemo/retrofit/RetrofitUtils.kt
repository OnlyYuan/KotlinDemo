package com.example.kotlindemo.retrofit

import android.R.id
import android.util.Log
import com.google.common.net.HttpHeaders
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.internal.cache.CacheInterceptor
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.io.File
import java.io.UnsupportedEncodingException
import java.net.URLDecoder
import java.util.concurrent.TimeUnit


/**
 * 用于构建 Retrofit.Builder
 *  1.设置日志拦截器 ，拦截返回json数据。并输入到控制台
 *
 */
class RetrofitUtils {

    var mRetrofit :Retrofit? = null

    companion object{

        fun getOkHttpClientBuilder():OkHttpClient.Builder{

            val loggingInterceptor = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
                override fun log(message: String) {
                    try {
                        Log.e("OKHttp-----", URLDecoder.decode(id.message.toString(), "utf-8"))
                    } catch (e: UnsupportedEncodingException) {
                        e.printStackTrace()
                        Log.e("OKHttp-----", id.message.toString())
                    }
                }
            })

            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

            //设置缓存
          val cacheFile = File("Utils.getContext().getCacheDir()", "cache")
           val cache = Cache(cacheFile, 1024 * 1024 * 100) //100Mb

            return OkHttpClient.Builder()
                    .readTimeout(1000,TimeUnit.MILLISECONDS) //
                    .connectTimeout(1000,TimeUnit.MILLISECONDS)//设置超时
                    .addInterceptor(loggingInterceptor)
                    .cache(cache)
        }
    }

    inline fun <reified T> getService():T{
        val retrofit = mRetrofit?: throw UnsupportedEncodingException("init first")
        return retrofit.create(T::class.java)
    }


}