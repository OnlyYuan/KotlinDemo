package com.example.kotlindemo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlindemo.R
import com.example.kotlindemo.utils.CircleColorView

class CircleColorActivity : AppCompatActivity() {

    var colorStringsList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_circle_color)
        colorStringsList.add("#FFB6C1")
        colorStringsList.add("#0000FF")
        colorStringsList.add("#6495ED")
        var mview = findViewById<CircleColorView>(R.id.mView);
        mview.setColorString(colorStringsList);
    }

}