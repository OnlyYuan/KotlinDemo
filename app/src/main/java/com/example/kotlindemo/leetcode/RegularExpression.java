package com.example.kotlindemo.leetcode;

/**
 * 10.正则表达式
 * 给你一个字符串s和一个字符规律p，请你来实现一个支持 '.'和'*'的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖整个字符串s的，而不是部分字符串。
 *
 */
public class RegularExpression {

    /**
     * 滑动窗口
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {

        //开始
        int start = 0;
        //窗口末尾
        int end = 0;

        char[] mChars = s.toCharArray();
        char[] fChars = p.toCharArray();


        for (int i = 0 ; i<s.length();i++){

            for (int j = 0;j <p.length();j++){

            }

        }


        return  true;
    }


}
