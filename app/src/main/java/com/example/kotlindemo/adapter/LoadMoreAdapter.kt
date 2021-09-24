package com.example.kotlindemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlindemo.R


class LoadMoreAdapter(val context: Context, var array: Array<String>): RecyclerView.Adapter<LoadMoreAdapter.ViewHolder>() {

    private var LOADING = 1;//加载更多
    private var NORMAL = 0;//正常情况

    //第一步 定义接口
    interface OnItemListener {
        fun onClick(position: Int)
    }

    private var listener: OnItemListener? = null

    //第二步， 写一个公共的方法
    fun setOnItemClickListener(listener: OnItemListener?) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view: View
       // if (viewType == NORMAL){
        view= LayoutInflater.from(parent.context).inflate(R.layout.loading_item, parent, false)
       // }
        return ViewHolder(view);
    }

    override fun getItemCount(): Int {
        return array.size + 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (position ==array.size){
            LOADING
        }else{
            NORMAL
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.loading.text = array[position]
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val loading:TextView = itemView.findViewById(R.id.loading)
    }

    inner class LoadingHolder(itemView: View) :RecyclerView.ViewHolder(itemView){

    }

}