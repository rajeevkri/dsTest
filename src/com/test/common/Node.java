package com.test.common;

public class Node {
    // keep these​​​​​​​​‌‌‌‌​‌​‌​​​​‌‌​​​​‌‌‌​‌ fields
    Node left, right;
	int value;

    Node find(int v) {
        Node x = null;
        boolean found = search(this, v, x);
        return x;
    }
    
    
    static boolean search(Node r, int val, Node x) {
		boolean found = false;
		while ((r != null) && !found) {
			int rval = r.value;
			if (val < rval)
				r = r.left;
			else if (val > rval)
				r = r.right;
			else {
				found = true;
				x = r;
				break;
			}
			found = search(r, val, x);
		}
		return found;
	}
}
