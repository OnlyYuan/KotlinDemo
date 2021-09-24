package com.example.kotlindemo.paging

import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer

class MViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),LayoutContainer {

    override val containerView = itemView

}