package com.ds.linkedlist;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sumNode = new ListNode(0);

        int carry = 0;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode temp3 = sumNode;

        while(temp1!= null && temp2!= null) {
            int sum = temp1.val + temp2.val + carry;
            carry = sum/10;
            sum = sum%10;
            temp3.next = new ListNode(sum);
            temp3 = temp3.next;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        while(temp1!= null ) {
            int sum = temp1.val + carry;
            carry = sum/10;
            sum = sum%10;
            temp3.next = new ListNode(sum);
            temp3 = temp3.next;
            temp1 = temp1.next;
        }
        while(temp2!= null) {
            int sum = temp2.val + carry;
            carry = sum/10;
            sum = sum%10;
            temp3.next = new ListNode(sum);
            temp3 = temp3.next;
            temp2 = temp2.next;
        }

        return sumNode.next;
    }

    public static void main(String[] args) {
        AddTwoNumbers sol = new AddTwoNumbers();
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);
        ListNode head1 = new ListNode(5);
        head1.next = new ListNode(6);
        head1.next.next = new ListNode(4);
//        head1.next.next.next = new ListNode(4);
//        head1.next.next.next.next = new ListNode(5);
//        head1.next.next.next.next.next = new ListNode(6);
        ListNode listNode = sol.addTwoNumbers(head, head1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
