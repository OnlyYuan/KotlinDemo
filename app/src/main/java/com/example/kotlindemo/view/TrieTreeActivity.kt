package com.example.kotlindemo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.kotlindemo.R
import com.example.kotlindemo.bean.Person
import com.example.kotlindemo.databinding.ActivityTrieTreeBinding
import com.example.kotlindemo.leetcode.*
import com.example.kotlindemo.leetcode.dongtaiduihua.Fibonacci
import com.example.kotlindemo.leetcode.dongtaiduihua.JumpGame
import com.example.kotlindemo.leetcode.dongtaiduihua.JumpGame2
import com.example.kotlindemo.leetcode.dongtaiduihua.RaidPlunder

/**
 * 前缀树处理
 * @author cpf
 */
class TrieTreeActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var mBinding :ActivityTrieTreeBinding
    lateinit var trie:Trie
    val nums = intArrayOf(3,2,4)
    var person = Person()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_trie_tree)
        initView()
    }



    private fun initView() {
        trie = Trie()
        mBinding.btn.setOnClickListener(this)
        mBinding.searchBtn.setOnClickListener(this)
        mBinding.allSearchBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
       when(v){

           mBinding.btn->{//添加按钮
               Log.i("11","-->点击了")
               val twoMatrix = RLEIterator(intArrayOf(3,8,0,9,2,5))
              // val m =   twoMatrix.(intArrayOf(2,3,1,1,4))
              // Log.i("11","-->点击了${m}")
           }

           mBinding.searchBtn ->{//联想搜索
               val text:String? = mBinding.searchInput.text.toString()
               if (text!=null&&text!=""){
                   //添加元素
                   val m = trie.startsWith(text)
                   Toast.makeText(this,"模糊搜索结果：${m}",Toast.LENGTH_SHORT).show()
               }

           }

           mBinding.allSearchBtn ->{//全问搜索
               val text:String? = mBinding.searchInput.text.toString()
               if (text!=null&&text!=""){
                   //添加元素
                   val m = trie.search(text)
                   Toast.makeText(this,"全文搜索结果：${m}",Toast.LENGTH_SHORT).show()
               }

           }
       }
    }
}
