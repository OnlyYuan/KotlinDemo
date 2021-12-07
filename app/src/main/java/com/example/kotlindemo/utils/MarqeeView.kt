package com.example.kotlindemo.utils

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView

class MarqeeView: androidx.appcompat.widget.AppCompatTextView{

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun isFocused(): Boolean {
        return true
    }

    override fun isSelected(): Boolean {
        return true
    }
}