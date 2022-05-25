package com.ds.linkedlist;

import java.util.HashSet;

public class CircularList {
//    public ListNode detectCycle(ListNode head) {
//        HashSet<Integer> nodes = new HashSet<>();
//        if(head ==null || head.next == null) return null;
//        ListNode temp = head;
//        ListNode res = null;
//        while(temp!= null) {
//            if(!nodes.contains(temp.val)) {
//                nodes.add(temp.val);
//                temp = temp.next;
//            } else {
//                res = temp;
//                break;
//            }
//        }
//        return res;
//    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow_p = head, fast_p = head;
        int flag = 0;
        while (slow_p != null && fast_p != null
                && fast_p.next != null) {
            slow_p = slow_p.next;
            fast_p = fast_p.next.next;
            if (slow_p == fast_p) {
                flag = 1;
                break;
            }
        }
        if (flag == 1)
        {
            ListNode p = slow_p;
            ListNode q = head;
            while(p != q) {
                p = p.next;
                q = q.next;
            }
            return p;
        }
        else
            return null;

    }

    public static void main(String[] args) {
//        ListNode headA = new ListNode(4); [-1,-7,7,-4,19,6,-9,-5,-2,-5]
//6
//        headA.next = new ListNode(1);
//        headA.next.next = joint;
        ListNode headB = new ListNode(-1);
        headB.next = new ListNode(-7);
        headB.next.next = new ListNode(7);
        ListNode joint = new ListNode(-4);
        headB.next.next.next = joint;
        joint.next = new ListNode(19);
        joint.next.next = new ListNode(6);
        joint.next.next.next = new ListNode(-9);
        joint.next.next.next.next = new ListNode(-5);
        joint.next.next.next.next.next = new ListNode(-2);
        joint.next.next.next.next.next.next = new ListNode(-5);

        CircularList cl = new CircularList();
        ListNode node = cl.detectCycle(headB);
        System.out.println(node.val);
    }
}
