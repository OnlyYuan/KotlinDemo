package com.example.kotlindemo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kotlindemo.adapter.MainMenuAdapter
import com.example.kotlindemo.databinding.ActivityMainUIBinding
import com.example.kotlindemo.view.TrieTreeActivity


class MainUIActivity : Activity(){

    lateinit var mBinding:ActivityMainUIBinding
    private val mTitle = arrayOf("前缀树")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main_u_i)

        initView()

    }

    private fun initView() {
       var  mAdapter = MainMenuAdapter(this, mTitle)

        //menu
        val gridLayoutManager = GridLayoutManager(this, 2)
        mBinding.recycler.layoutManager = gridLayoutManager
        mBinding.recycler.adapter = mAdapter
        mAdapter.setOnItemClickListener(object : MainMenuAdapter.OnItemListener{
            override fun onClick(position: Int) {
                when(position){
                    0->{//前缀树
                        var intent = Intent(this@MainUIActivity,TrieTreeActivity::class.java)
                        startActivity(intent)
                    }

                }
            }
        })
    }



}
