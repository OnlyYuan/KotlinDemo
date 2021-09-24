package com.example.kotlindemo.leetcode;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 900. RLE 迭代器
 * 编写一个遍历游程编码序列的迭代器。
 * 迭代器由 RLEIterator(int[] A) 初始化，其中A是某个序列的游程编码。更具体地，对于所有偶数 i，A[i] 告诉我们在序列中重复非负整数值 A[i + 1] 的次数。
 * 迭代器支持一个函数：next(int n)，它耗尽接下来的 n 个元素（n >= 1）并返回以这种方式耗去的最后一个元素。如果没有剩余的元素可供耗尽，则  next 返回 -1 。
 * 例如，我们以A = [3,8,0,9,2,5]开始，这是序列[8,8,8,5,5]的游程编码。这是因为该序列可以读作 “三个八，零个九，两个五”。
 */
public class RLEIterator {
    //数量的编号， 累加
    List<Long> mData =null;
    //当前的值
    HashMap<Integer,Integer> mHashMap = null;
    //next的总数
    Long totalNum = 0L;
    Long mIndexSum = 0L;
    int start = 0 ;

    public RLEIterator(int[] encoding) {
        mHashMap = new HashMap<>();
        mData = new ArrayList<Long>();
        int index = 0;
        int mIndex = 0;

        while (index < encoding.length){
            if (encoding[index]!=0){
                mIndexSum += encoding[index];
                mData.add(mIndexSum);
                mHashMap.put(mIndex,encoding[index+1]);
                mIndex ++;
            }
            index += 2;
        }

        Log.i("111","--->"+mData.toString() );

        mHashMap.forEach((k, v) -> System.out.println("key: " + k + " value:" + v));
    }

    public int next(int n) {

        totalNum += n;

        if (totalNum>mIndexSum){
            return -1;
        }

        for (int i = start;i< mData.size();i++){
            if(totalNum < mData.get(i)){
                start = i;
                break;
            }
        }

        return mHashMap.get(start);
    }
}
