package com.example.kotlindemo.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

import com.example.kotlindemo.ViewPager2Activity

class MyFragmentAdpter(viewPager2Activity:ViewPager2Activity,var fragmentList: MutableList<Fragment>):FragmentStateAdapter( viewPager2Activity){


    override fun getItemCount(): Int {

       return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {

        return fragmentList[position]
    }
}