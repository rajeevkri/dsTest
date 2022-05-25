package com.ds.linkedlist;

import java.util.List;

public class SwapNode {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode iter = head;
        ListNode last = head;
        head = iter.next;
        while(iter != null && iter.next!=null) {
            ListNode temp = iter.next;
            last.next = temp;
            ListNode next = temp.next;
            temp.next = iter;
            temp.next.next = next;
            last = iter;
            last.next = iter.next;
            iter = next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

//        head.next.next.next = new ListNode(1);
        SwapNode sol = new SwapNode();
        ListNode out = sol.swapPairs(head);
        while (out != null) {
            System.out.println(out.val + " ");
            out = out.next;
        }
//        System.out.println(out);
    }

    public ListNode swapNodes(ListNode head, int k) {
        ListNode kFromStart = head;
        ListNode kFromLast = head;
        ListNode last = head;
        for(int i =1; i< k ; i++) {
            last = last.next;
        }
        kFromStart = last;
        while(last.next != null) {
            last = last.next;
            kFromLast = kFromLast.next;
        }
        //swap values
        int temp = kFromLast.val;
        kFromLast.val = kFromStart.val;
        kFromStart.val = temp;
        return head;
    }
}
