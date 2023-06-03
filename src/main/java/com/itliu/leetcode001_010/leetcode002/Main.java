package com.itliu.leetcode001_010.leetcode002;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @create 2023-06-03-9:35
 */

public class Main {
    public static void main(String[] args) {
//        l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
        // 创建链表 l1
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);

        // 创建链表 l2
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);

        // 调用 addTwoNumbers 方法并获取结果
        addTwoNumbers_1 solution = new addTwoNumbers_1();
        ListNode result = solution.addTwoNumbers(l1, l2);

        // 将结果链表的值存入列表
        List<Integer> resultList = new ArrayList<>();
        while (result != null) {
            resultList.add(result.val);
            result = result.next;
        }

        // 将列表转换为数组并输出
        Integer[] resultArray = resultList.toArray(new Integer[0]);  //将集合转换为一个对象数组,
        // new Integer[0] 创建了一个空的 Integer 类型的数组，作为目标数组用于存储 resultList 的元素。
        System.out.println(Arrays.toString(resultArray));
    }
}