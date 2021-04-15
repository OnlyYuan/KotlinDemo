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
import com.example.kotlindemo.leetcode.Rob
import com.example.kotlindemo.leetcode.Trie
import java.time.Period

/**
 * 前缀树处理
 * @author cpf
 */
class TrieTreeActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var mBinding :ActivityTrieTreeBinding
    lateinit var trie:Trie
    val nums = intArrayOf(2,3,2,1,3)
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
               var rob = Rob()
               rob.rob(nums)
               Log.i("11","-->${  rob.rob(nums)}")
//               val text:String? = mBinding.input.text.toString()
//               if (text!=null&&text!=""){
//                   //添加元素
//                   val m =  trie.insert(text)
//                   trie.outputTree()
//               }
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