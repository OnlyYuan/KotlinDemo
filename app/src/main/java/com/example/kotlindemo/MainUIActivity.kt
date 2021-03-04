package com.example.kotlindemo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.kotlindemo.fragment.BlankFragment1
import com.example.kotlindemo.fragment.BlankFragment2


class MainUIActivity : Activity(), View.OnClickListener {

    lateinit var viewPagerbtn: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_u_i)

        initView()
        initLinsener()
    }


    private fun initView() {
        viewPagerbtn = findViewById(R.id.viewPagerLayout)
    }

    private fun initLinsener() {
        viewPagerbtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
       when(v){
           viewPagerbtn -> {

               var intent = Intent(this@MainUIActivity, ViewPager2Activity::class.java)
               startActivity(intent)
           }
       }
    }
}
