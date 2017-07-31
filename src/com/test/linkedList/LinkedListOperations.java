package com.test.linkedList;

import java.util.LinkedList;

public class LinkedListOperations {

	/**
	 * remove any node whose value is greater than x
	 * 
	 * @param list
	 * @param x
	 * @return
	 */
	public static LinkedListNode removeNodes(LinkedListNode list, int x) {
		if (list == null)
			return list;
		LinkedListNode newHead = new LinkedListNode(0);
		newHead.next = list;
        LinkedListNode temp = newHead;
        while (temp.next != null) {
            if (temp.next.val > x) {
            	temp.next = temp.next.next;
            }
            else temp = temp.next;
        }
        
		return newHead.next;
	}

	public static LinkedListNode addTwoLists(LinkedListNode first, LinkedListNode second) {
		LinkedListNode result = null;
		LinkedListNode prev = null;
		int carry = 0, sum;

		while (first != null || second != null) {
			sum = carry + (first != null ? first.val : 0) + (second != null ? second.val : 0);
			carry = sum > 10 ? 1 : 0;
			sum = sum % 10;
			LinkedListNode temp = new LinkedListNode(sum);
			if (result == null) {
				result = temp;
				prev =result;
			} else {
				prev.next = temp;
			}
			prev = temp;
			if (first != null) {
				first = first.next;
			}
			if (second != null) {
				second = second.next;
			}
		}
		if (carry > 0) {
			result.next = new LinkedListNode(carry);
		}

		return result;

	}
	
	/* Adds contents of two linked lists and return the head node of resultant list */
	static LinkedListNode addTwoListsOther(LinkedListNode first, LinkedListNode second) {
		LinkedListNode res = null; // res is head node of the resultant list
		LinkedListNode prev = null;
		LinkedListNode temp = null;
        int carry = 0, sum;
 
        while (first != null || second != null) //while both lists exist
        {
            // Calculate value of next digit in resultant list.
            // The next digit is sum of following things
            // (i)  Carry
            // (ii) Next digit of first list (if there is a next digit)
            // (ii) Next digit of second list (if there is a next digit)
            sum = carry + (first != null ? first.val : 0)
                    + (second != null ? second.val : 0);
 
            // update carry for next calulation
            carry = (sum >= 10) ? 1 : 0;
 
            // update sum if it is greater than 10
            sum = sum % 10;
 
            // Create a new node with sum as data
            temp = new LinkedListNode(sum);
 
            // if this is the first node then set it as head of
            // the resultant list
            if (res == null) {
                res = temp;
            } else // If this is not the first node then connect it to the rest.
            {
                prev.next = temp;
            }
 
            // Set prev for next insertion
            prev = temp;
 
            // Move first and second pointers to next nodes
            if (first != null) {
                first = first.next;
            }
            if (second != null) {
                second = second.next;
            }
        }
 
        if (carry > 0) {
            temp.next = new LinkedListNode(carry);
        }
 
        // return head of the resultant list
        return res;
    }

	static void printList(LinkedListNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println("");
	}

	public static void main(String[] args) {

		// creating first list
		LinkedListNode head1 = new LinkedListNode(7);
		head1.next = new LinkedListNode(5);
		head1.next.next = new LinkedListNode(9);
		head1.next.next.next = new LinkedListNode(4);
		head1.next.next.next.next = new LinkedListNode(6);
		System.out.print("First List is ");
		printList(head1);

		// creating seconnd list
		LinkedListNode head2 = new LinkedListNode(8);
		head2.next = new LinkedListNode(4);
		head2.next.next = new LinkedListNode(5);
		head2.next.next.next = new LinkedListNode(6);
		System.out.print("Second List is ");
		printList(head2);

		// add the two lists and see the result
		LinkedListNode rs = addTwoListsOther(head1, head2);
		System.out.print("Resultant List is ");
		printList(rs);
	}
}
