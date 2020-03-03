package com.fkk.code;

import com.fkk.code.entity.ListNode;

import java.util.List;

public class _206_ReverseList {

    public static ListNode reverse_01(ListNode head) {

        ListNode node = null;
        while (head != null) {
            ListNode temp = new ListNode(head.val);
            temp.next = node;
            node = temp;
            head = head.next;
        }
        return node;
    }

    public static ListNode reverse_02(ListNode head) {

        ListNode node = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = node;
            node = head;
            head = temp;
        }
        return node;
    }

    public static ListNode reverse_03(ListNode head) {


        return null;
    }

}