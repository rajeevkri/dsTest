package com.test.hackerrank.linkedlist;

public class Operations {
	public static void Print(Node head) {
		Node node = head;
		while (node != null) {
			System.out.println(node.data);
			node = node.next;
		}
	}

	//Insert at last
	Node InsertAtLast(Node head, int data) {
		Node prev = head;
		Node node = head;
		while (node != null) {
			prev = node;
			node = node.next;
		}
		Node temp = new Node();
		temp.data = data;
		prev.next = temp;
		return head;
	}

	//Insert node at start
	Node Insert(Node head,int x) {
	    Node temp = new Node();
	    temp.data = x;
	    temp.next = head;
	    return temp;
	}
}
