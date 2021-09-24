package com.example.kotlindemo.paging

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.kotlindemo.R

class MPagingAdapter: PagingDataAdapter<MData,MViewHolder>(diffCallback) {
    override fun onBindViewHolder(holder: MViewHolder, position: Int) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.menu_item, parent, false)
        return MViewHolder(view)
    }

    companion object{

        val diffCallback =object :DiffUtil.ItemCallback<MData>(){
            override fun areItemsTheSame(oldItem: MData, newItem: MData): Boolean {
                TODO("Not yet implemented")
            }

            override fun areContentsTheSame(oldItem: MData, newItem: MData): Boolean {
                TODO("Not yet implemented")
            }


        }
    }

}