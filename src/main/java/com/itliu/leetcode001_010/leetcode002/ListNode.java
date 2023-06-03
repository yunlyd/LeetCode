package com.itliu.leetcode001_010.leetcode002;

/**
 * @create 2023-06-03-9:08
 */
public class ListNode {
    int val;            // 存储节点的值
    ListNode next;      // 存储指向下一个节点的引用

    ListNode() {
        // 无参构造函数
    }

    ListNode(int val) {
        this.val = val;    // 使用给定的值初始化节点
    }

    ListNode(int val, ListNode next) {
        this.val = val;    // 使用给定的值初始化节点
        this.next = next;  // 使用给定的引用连接到下一个节点
    }
}






