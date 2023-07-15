package com.llllz.leetcode001_010.leetcode002;

/**
 * @create 2023-06-03-8:43
 */
public class Solution_1 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;  // 定义头节点和尾节点，用于构建结果链表
        int carry = 0;  // 进位值，初始为0
        while (l1 != null || l2 != null) {  // 遍历链表直到两个链表都为空
            int n1 = l1 != null ? l1.val : 0;  // 获取链表l1当前节点的值，若为空则为0
            int n2 = l2 != null ? l2.val : 0;  // 获取链表l2当前节点的值，若为空则为0
            int sum = n1 + n2 + carry;  // 两节点的值相加再加上进位值
            if (head == null) {
                //这种写法的目的是在创建链表的过程中同时设置头节点和尾节点的初始值。
                // 在第一次循环中，创建的新节点既是头节点又是尾节点，因为此时只有一个节点，它即是链表的起始节点也是结束节点。
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);  // 创建新节点，并将其连接到尾节点的后面
                tail = tail.next;  // 将尾节点指针指向新节点
            }
            carry = sum / 10;  // 计算新的进位值
            if (l1 != null) {
                l1 = l1.next;  // 移动l1指针到下一个节点
            }
            if (l2 != null) {
                l2 = l2.next;  // 移动l2指针到下一个节点
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);  // 若最后还有进位值，则创建新节点连接到尾节点后面
        }
        return head;  // 返回结果链表的头节点
    }
}