package com.ds.linkedlist;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
//        if(head.next == null || n ==1 ){
//            return  null;
//        }
        for (int i = 0; i < n; i++) {
            if (first.next != null) {
                first = first.next;
            }
        }
        ListNode second = head;
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        if (second.next == null) {
            second = null;
        } else {
            second.next = second.next.next;
        }

        return head;
    }

    /*public static void main(String[] args) {
        ListNode head = new ListNode(1);
        Solution sol = new Solution();
        ListNode out = sol.removeNthFromEnd(head, 1);
        System.out.println(out);
    }*/

    /**
     * this is correct
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        // Move fast pointer n steps ahead
        for (int i = 0; i < n; i++) {
            if (fast.next == null) {
                // If n is equal to the number of nodes, delete the head node
                if (i == n - 1) {
                    head = head.next;
                }
                return head;
            }
            fast = fast.next;
        }
        // Loop until we reach to the end.
        // Now we will move both fast and slow pointers
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // Delink the nth node from last
        if (slow.next != null) {
            slow.next = slow.next.next;
        }
        return head;
    }

    public ListNode middleNode(ListNode head) {
        if (head == null)
            return head;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;
        if (head.next == null)
            return true;
        int l = 0;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            l++;
            fast = fast.next.next;
        }
        int[] arr = new int[l];
        slow = head;
        for (int i = 0; i < l; i++) {
            arr[i] = slow.val;
            slow = slow.next;
        }
        boolean isPal = true;
        int i = l - 1;
        if (fast != null) {
            slow = slow.next;
        }
        while (slow != null) {
            if (slow.val != arr[i]) {
                isPal = false;
                break;
            }
            slow = slow.next;
            i--;
        }
        return isPal;
    }

//    public static void main(String[] args) {
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(2);
////        head.next.next.next = new ListNode(1);
//        Solution sol = new Solution();
//        boolean out = sol.isPalindrome(head);
//        System.out.println(out);
//    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(4);

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(4);

//        head.next.next.next = new ListNode(1);
        Solution sol = new Solution();
        ListNode out = sol.mergeTwoLists(head, head1);
        while (out != null) {
            System.out.println(out.val + " ");
            out = out.next;
        }
//        System.out.println(out);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        ListNode xyz;
        if (temp1.val > temp2.val) {
            xyz = temp2;
            temp2 = temp2.next;
        } else {
            xyz = temp1;
            temp1 = temp1.next;
        }
        ListNode temp = xyz ;
        while (temp1 != null && temp2 != null) {
            if (temp1.val > temp2.val) {
                xyz.next = temp2;
                temp2 = temp2.next;
            } else {
                xyz.next = temp1;
                temp1 = temp1.next;
            }
            xyz = xyz.next;
        }
        if (temp1 != null) {
            xyz.next = temp1;
        }
        if (temp2 != null) {
            xyz.next = temp2;
        }
        return temp;
    }
}


