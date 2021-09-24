package com.example.kotlindemo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.View
import androidx.compose.ui.graphics.Color
import com.example.kotlindemo.R
import com.example.kotlindemo.bean.MsgBean
import com.google.gson.Gson

class JiexiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jiexi)

        val str = resources.assets.open("mdata.txt").bufferedReader().readLine()
        //Log.i("1","--->${str}")
        val data = Gson().fromJson(str, MsgBean::class.java)
       // Log.i("1","--->${data.response_data?.user_list?.get(0)?.user_info?.follower_count}")
        outPut(data)
    }

    fun outPut(data:MsgBean?){
        var list = data?.response_data?.user_list

        list?.let {
            for ( e in it){

                Log.i("11","----->nickname:${e.user_info?.nickname} 粉丝数：${e.user_info?.follower_count}  " +
                        "versatile_display:${e.user_info?.versatile_display} 点赞：${e.user_info?.total_favorited}")
            }
        }
    }

    override fun onResume() {
        super.onResume()
    }
}