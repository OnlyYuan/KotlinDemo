package com.example.kotlindemo

import android.content.Intent
import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import okhttp3.*
import java.io.File
import java.io.IOException


class MainViewMode: ViewModel() {

        var editString: String
            get() =editString
            set(value) {
                editString=value
            }

         var showString:String
            get()=showString
            set(s){
                showString=s
            }
}


