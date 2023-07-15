package com.llllz.leetcode001_010.leetcode001;

import java.util.Arrays;

/**
 * @create 2023-06-02-8:51
 */
public class Solution_2 {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        Solution_1 a = new Solution_1();
        int[] ints = a.twoSum(nums, target);
        System.out.println(Arrays.toString(ints));
    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }
}
/*int转string的方法:
 *String.valueof(i)
 * Interger.tostring(i)
 * i+""
 */