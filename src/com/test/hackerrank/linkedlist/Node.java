package com.test.hackerrank.linkedlist;

public class Node {
	int data;
	Node next;

	public Node() {
	}
	Node(int node_value) {
		data = node_value;
		next = null;
	}
	
	public static Node _insert_node_into_singlylinkedlist(Node head, Node tail, int val){
        if(head == null) {
            head = new Node(val);
            tail = head;
        }
        else {
            tail.next = new Node(val);
            tail = tail.next;
        }
        return tail;
    }
}