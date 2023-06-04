package com.itliu.leetcode001_010.leetcode003;

import java.util.HashMap;

/**
 * @create 2023-06-04-9:12
 */
/** 滑动窗口
 * 什么是滑动窗口？
 *
 * 其实就是一个队列,比如例题中的 abcabcbb，进入这个队列（窗口）为 abc 满足题目要求，当再进入 a，队列变成了 abca，这时候不满足要求。
 * 所以，我们要移动这个队列！
 *
 * 如何移动？
 * 我们只要把队列的左边的元素移出就行了，直到满足题目要求！
 * 一直维持这样的队列，找出队列出现最长的长度时候，求出解！
 */
public class Solution_1 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)  // 如果字符串为空，直接返回0
            return 0;
        // 创建一个HashMap，用于存储字符和其最新出现的索引
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;  // 用于记录最长子串的长度
        int left = 0;  // 用于记录当前无重复字符子串的起始位置

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {  // 如果字符已经在HashMap中存在，表示出现重复字符
                left = Math.max(left, map.get(s.charAt(i)) + 1);  // 更新左边界为当前重复字符的位置
            }
            map.put(s.charAt(i), i);  // 将字符和其索引加入HashMap中，更新最新出现的位置
            max = Math.max(max, i - left + 1);  // 更新最长子串的长度
        }
        return max;  // 返回最长子串的长度
    }
}

/**
 * charAt() 是一个字符串方法，用于返回指定索引处的字符。
 *
 * 它的语法如下：
 * java
 *
 * char charAt(int index)
 *
 * index：要获取字符的索引，从 0 开始计数。
 * 该方法会返回字符串中指定索引位置的字符。例如，对于字符串 str = "Hello"：
 *
 * str.charAt(0) 返回 'H'，因为 'H' 是索引 0 处的字符。
 * str.charAt(4) 返回 'o'，因为 'o' 是索引 4 处的字符。
 * charAt() 方法常用于遍历字符串中的每个字符，通过循环结合索引逐个处理字符串的字符。
 */