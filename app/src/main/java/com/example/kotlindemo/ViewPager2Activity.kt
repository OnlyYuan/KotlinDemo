package com.example.kotlindemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.kotlindemo.adapter.MyFragmentAdpter
import com.example.kotlindemo.databinding.ActivityViewPager2Binding
import com.example.kotlindemo.fragment.BlankFragment1
import com.example.kotlindemo.fragment.BlankFragment2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ViewPager2Activity : AppCompatActivity() {

    lateinit var dataBinding:ActivityViewPager2Binding
    lateinit var mtabs: TabLayout
    lateinit var mview_pager: ViewPager2
    lateinit  var fragmentList: MutableList<Fragment>
    lateinit  var mtabStrings: List<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this,R.layout.activity_view_pager2)

        initView()

        initData()
    }

    private fun initData() {

        mtabStrings= arrayListOf("一","二")
        val fragment1 = BlankFragment1()
        val fragment2 = BlankFragment2()

        fragmentList =ArrayList<Fragment>()
        fragmentList?.add(fragment1)
        fragmentList?.add(fragment2)

        var adpter=MyFragmentAdpter(this@ViewPager2Activity,fragmentList)

        mview_pager.adapter =adpter
       // mview_pager.setPageTransformer()
        TabLayoutMediator(mtabs,mview_pager){
                tab, position -> tab.text ="${mtabStrings[position]}"


        }.attach()

    }

    private fun initView() {
        mtabs = findViewById(R.id.tabs)
        mview_pager= findViewById(R.id.view_pager)
    }
}
