package com.itliu.leetcode001_010.leetcode005;

/**
 * @create 2023-06-11-8:45
 */
public class Main {
    public static void main(String[] args) {
        Solution_1 solution = new Solution_1();

        String s1 = "babad";
        String result1 = solution.longestPalindrome(s1);
        System.out.println("输入: " + s1);
        System.out.println("输出: " + result1);
        System.out.println();

        String s2 = "cbbd";
        String result2 = solution.longestPalindrome(s2);
        System.out.println("输入: " + s2);
        System.out.println("输出: " + result2);
    }
}