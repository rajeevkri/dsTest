package com.ds.linkedlist;

public class IntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int l1 = 0;
        int l2 = 0;
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        while(temp1!=null) {
            l1++;
            temp1 = temp1.next;
        }
        while(temp2!=null) {
            l2++;
            temp2 = temp2.next;
        }
        int diff = l1>l2?l1-l2:l2-l1;
        temp1 = headA;
        temp2 = headB;
        ListNode common = null;
        if (l1>l2) {
            for (int i = 0; i<diff; i++) {
                temp1 = temp1.next;
            }
        }
        if (l1<l2) {
            for (int i = 0; i<diff; i++) {
                temp2 = temp2.next;
            }
        }
        while (temp1!=null) {
            if (temp1.equals(temp2)) {
                common = temp1;
                break;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return common;
    }

    public static void main(String[] args) {
        ListNode joint = new ListNode(8);
        joint.next = new ListNode(4);
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = joint;
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = joint;
        IntersectionNode sol = new IntersectionNode();
        ListNode out = sol.getIntersectionNode(headA, headB);
        System.out.println(out.val);
    }
}
