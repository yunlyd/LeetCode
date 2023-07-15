package com.llllz.leetcode001_010.leetcode006;

/**
 * @create 2023-07-15-10:34
 */
public class Main {
    public static void main(String[] args) {
        Solution_1 solution = new Solution_1();

        String s1 = "aa";
        String p1 = "a";
        System.out.println(solution.isMatch(s1, p1)); // false

        String s2 = "aa";
        String p2 = "a*";
        System.out.println(solution.isMatch(s2, p2)); // true

        String s3 = "ab";
        String p3 = ".*";
        System.out.println(solution.isMatch(s3, p3)); // true

        String s4 = "mississippi";
        String p4 = "mis*is*ip*.";
        System.out.println(solution.isMatch(s4, p4)); // true
    }
}