package com.ds.linkedlist;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        if(k ==0) return head;
        int length = 0;
        ListNode temp = head;
        ListNode temp1 = null;
        while(temp != null) {
            temp1 = temp;
            temp = temp.next;
            length++;
        }
        k = k % length;
        if(k ==0) return head;
        int x = length - k;
        ListNode last = temp1;
        temp = head;
        temp1 = null;
        for(int i=0; i<x; i++) {
            temp1 = temp;
            temp = temp.next;
        }
        last.next = head;
        head = temp;
        temp1.next = null;
        return head;
    }
}
