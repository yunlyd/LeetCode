package com.itliu.leetcode001_010.leetcode004;

public class Solution_2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length; // 数组 nums1 的长度
        int n = nums2.length; // 数组 nums2 的长度
        // 确保 nums1 是较短的数组
        if (m > n) {
            int[] temp = nums1;  // 交换数组引用
            nums1 = nums2;
            nums2 = temp;
            int tempLen = m;  // 交换数组长度
            m = n;
            n = tempLen;
        }

        int left = 0;  // 左边界
        int right = m;  // 右边界
        int halfLen = (m + n + 1) / 2;  // 合并后数组的一半长度

        while (left <= right) {
            int i = (left + right) / 2;  // 在 nums1 中的分割点
            int j = halfLen - i;  // 在 nums2 中的分割点

            if (i < m && nums2[j - 1] > nums1[i]) {
                // i 偏小，增大 i
                left = i + 1;
            } else if (i > 0 && nums1[i - 1] > nums2[j]) {
                // i 偏大，减小 i
                right = i - 1;
            } else {
                // i 符合要求，找到了合适的分割点

                int maxLeft;
                if (i == 0) {
                    maxLeft = nums2[j - 1];  // 左半部分的最大值
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];  // 左半部分的最大值
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);  // 左半部分的最大值
                }

                // 如果总长度是奇数，则中位数就是左半部分的最大值
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight;
                if (i == m) {
                    minRight = nums2[j];  // 右半部分的最小值
                } else if (j == n) {
                    minRight = nums1[i];  // 右半部分的最小值
                } else {
                    minRight = Math.min(nums1[i], nums2[j]);  // 右半部分的最小值
                }

                // 如果总长度是偶数，则中位数是左半部分的最大值和右半部分的最小值的平均值
                return (maxLeft + minRight) / 2.0;
            }
        }

        // 如果没有找到中位数，返回一个错误的结果
        return 0.0;
    }
}