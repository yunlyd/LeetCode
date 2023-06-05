package com.itliu.leetcode001_010.leetcode004;

/**
 * @create 2023-06-05-19:44
 */
public class Solution_1 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums; // 创建一个数组来存储合并后的有序数组
        int m = nums1.length; // 数组 nums1 的长度
        int n = nums2.length; // 数组 nums2 的长度
        nums = new int[m + n]; // 创建一个长度为 m+n 的数组来存储合并后的有序数组

        // 处理其中一个数组为空的情况
        if (m == 0) {
            if (n % 2 == 0) { // 如果数组 nums2 的长度是偶数
                return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0; // 返回中间两个数的平均值
            } else {
                return nums2[n / 2]; // 返回中间的数
            }
        }
        if (n == 0) {
            if (m % 2 == 0) { // 如果数组 nums1 的长度是偶数
                return (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0; // 返回中间两个数的平均值
            } else {
                return nums1[m / 2]; // 返回中间的数
            }
        }

        int count = 0; // 记录合并后数组的当前位置
        int i = 0, j = 0; // 分别表示数组 nums1 和 nums2 的当前位置

        while (count != (m + n)) { // 当合并后数组的元素还未完全填充时循环
            if (i == m) { // 如果数组 nums1 的元素已经全部合并完毕
                while (j != n) { // 将数组 nums2 剩余的元素直接添加到合并后的数组中
                    nums[count++] = nums2[j++];
                }
                break; // 结束循环
            }
            if (j == n) { // 如果数组 nums2 的元素已经全部合并完毕
                while (i != m) { // 将数组 nums1 剩余的元素直接添加到合并后的数组中
                    nums[count++] = nums1[i++];
                }
                break; // 结束循环
            }

            if (nums1[i] < nums2[j]) { // 如果数组 nums1 的当前元素小于数组 nums2 的当前元素
                nums[count++] = nums1[i++]; // 将 nums1 的当前元素添加到合并后的数组中，并将 i 和 count 分别加1
            } else {
                nums[count++] = nums2[j++]; // 如果数组 nums2 的当前元素小于等于数组 nums1 的当前元素，则将 nums2 的当前元素添加到合并后的数组中，并将 j 和 count 分别加1
            }
        }

        if (count % 2 == 0) { // 如果合并后的数组长度为偶数
            return (nums[count / 2 - 1] + nums[count / 2]) / 2.0; // 返回中间两个数的平均值
        } else {
            return nums[count / 2]; // 返回中间的数
        }
    }
}