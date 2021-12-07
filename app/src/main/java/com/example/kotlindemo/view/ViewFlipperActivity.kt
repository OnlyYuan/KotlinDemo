package com.example.kotlindemo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.kotlindemo.R
import com.example.kotlindemo.databinding.ActivityMainUIBinding
import com.example.kotlindemo.databinding.ActivityViewFlipperBinding

class ViewFlipperActivity : AppCompatActivity() {
    lateinit var mBinding: ActivityViewFlipperBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_view_flipper)

    }
}