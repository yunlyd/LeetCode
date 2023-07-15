package com.llllz.leetcode001_010.leetcode003;

/**
 * @create 2023-06-04-9:12
 */
public class Main {
    public static void main(String[] args) {
        Solution_1 solution = new Solution_1();
//        String s = "abcabcbb";
        String s = "abcbefbbb";
        int length =  solution.lengthOfLongestSubstring(s);
        System.out.println("当输入字符串 " + s +" 时，无重复字符的最长子串为 "+ length);
    }
}