package com.example.kotlindemo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlindemo.R
import com.example.kotlindemo.adapter.LoadMoreAdapter
import com.example.kotlindemo.databinding.ActivityLoadMoreBinding

class LoadMoreActivity : AppCompatActivity() {

    var array = arrayOf("方法一","方法二");
    lateinit var recycler:RecyclerView;
    lateinit var binding:ActivityLoadMoreBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_load_more)

        var adapter:LoadMoreAdapter = LoadMoreAdapter(this,array)
        val linearLayoutManager = LinearLayoutManager(this)
        binding.recycler.layoutManager = linearLayoutManager
        binding.recycler.adapter = adapter
        recycler.setOnScrollChangeListener(object :View.OnScrollChangeListener{
            override fun onScrollChange(
                v: View?,
                scrollX: Int,
                scrollY: Int,
                oldScrollX: Int,
                oldScrollY: Int
            ) {


            }

        })
    }
}