package com.example.kotlindemo.leetcode.dongtaiduihua;

import java.util.HashMap;

/**
 *740. 删除并获得点数
 *给你一个整数数组nums，你可以对它进行一些操作。
 * 每次操作中，选择任意一个nums[i]，删除它并获得nums[i]的点数。之后，你必须删除 所有 等于nums[i] - 1 和 nums[i] + 1的元素。
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 *
 */
public class DeleteGetNum {

    //转为偷东西
    public int deleteAndEarn(int[] nums) {

        HashMap<Integer,Integer> hashMap = new HashMap<Integer, Integer>();

        for (int element:nums) {
            if (hashMap.containsKey(element)){
                int mCount = element+hashMap.get(element);
                hashMap.put(element,mCount);
            }else {
                hashMap.put(element,element);
            }
        }

        int max = 0;



        return 0;
    }

}
