package com.example.kotlindemo.model.api


import com.example.kotlindemo.model.bean.ImageBackBean
import com.example.kotlindemo.model.bean.WordTokenBackBean
import retrofit2.Call
import retrofit2.http.*


interface ApiService{

    //token 生成的接口
    @POST("token")
    fun getToken(@Query("grant_type")grant_type:String
                 ,@Query("client_id")client_id:String,
                 @Query("client_secret")client_secret:String): Call<WordTokenBackBean>


    //上传图片接口
    @Headers("Content-Type:application/x-www-form-urlencoded")
    @POST("accurate_basic")
    fun upLoadImage(@Query("access_token")access_token:String,@Query("image") image:String):Call<ImageBackBean>

}