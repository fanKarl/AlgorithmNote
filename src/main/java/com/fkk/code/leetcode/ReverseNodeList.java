package com.fkk.code.leetcode;

import com.fkk.code.entity.ListNode;

/**
 * 206 反转链表：https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class ReverseNodeList {

    public static ListNode reverseNodeListA(ListNode head) {

        ListNode node = null;
        while (head != null) {
            ListNode temp = new ListNode(head.val);
            temp.next = node;
            node = temp;
            head = head.next;
        }
        return node;
    }

    public static ListNode reverseNodeListB(ListNode head) {

        ListNode node = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = node;
            node = head;
            head = temp;
        }
        return node;
    }
}
