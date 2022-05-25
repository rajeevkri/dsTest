package com.ds.linkedlist;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class DeleteDuplicates2 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);

        dummy.next = head;
        ListNode prev = dummy;
        ListNode current = head;

        while (current != null)
        {
            while (current.next != null &&
                    prev.next.val == current.next.val)
                current = current.next;

            if (prev.next == current)
                prev = prev.next;

            else
                prev.next = current.next;

            current = current.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode joint = new ListNode(1);
        joint.next = new ListNode(2);
        ListNode headA = new ListNode(2);
        headA.next = new ListNode(3);
        joint.next.next = headA;
        ListNode headB = new ListNode(3);
        headB.next = new ListNode(4);
        headB.next.next = new ListNode(4);
        headB.next.next.next = new ListNode(5);
        headA.next.next = headB;
        DeleteDuplicates2 sol = new DeleteDuplicates2();
        ListNode out = sol.deleteDuplicates(joint);
        while (out!=null) {
            System.out.println(out.val);
            out = out.next;
        }
    }
}
