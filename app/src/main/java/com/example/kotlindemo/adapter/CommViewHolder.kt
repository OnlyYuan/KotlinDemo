package com.example.kotlindemo.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer

/**
 * 公用viewholder
 */
class CommViewHolder(itemView: View):RecyclerView.ViewHolder(itemView),LayoutContainer {

    override val containerView = itemView

}