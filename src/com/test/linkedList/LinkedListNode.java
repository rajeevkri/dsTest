package com.test.linkedList;

public class LinkedListNode {
	int val;
	LinkedListNode next;

	LinkedListNode(int node_value) {
		val = node_value;
		next = null;
	}
	
	public static LinkedListNode _insert_node_into_singlylinkedlist(LinkedListNode head, LinkedListNode tail, int val){
        if(head == null) {
            head = new LinkedListNode(val);
            tail = head;
        }
        else {
            tail.next = new LinkedListNode(val);
            tail = tail.next;
        }
        return tail;
    }
}