package com.itliu.leetcode001_010.leetcode004;

/**
 * @create 2023-06-05-19:44
 */
public class Main {
    public static void main(String[] args) {
        Solution_1 solution = new Solution_1();

        // 示例 1
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double result1 = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println("示例 1 输出: " + result1); // 预期输出: 2.00000


        Solution_2 solution2 = new Solution_2();
        // 示例 2
        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};
        double result2 = solution2.findMedianSortedArrays(nums3, nums4);
        System.out.println("示例 2 输出: " + result2); // 预期输出: 2.50000
    }
}