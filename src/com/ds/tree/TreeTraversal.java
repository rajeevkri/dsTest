package com.ds.tree;

import java.util.Scanner;
import java.util.Stack;

public class TreeTraversal {

    /**
     * for iterative pre order traversal put right child first in stack
     * @param root
     */
    public static void iterativePreOrder(Node root) {
        if(root == null)
            return;
        Stack<Node> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()) {
            Node n = st.pop();
            System.out.print(n.data + " ");
            if(n.right != null)
                st.push(n.right);
            if(n.left != null)
                st.push(n.left);

        }
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    /**
     * provide input like below :-
     * number of node
     * list of node
     * e.g.
     * 6
     * 1 2 5 3 6 4
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        iterativePreOrder(root);

    }
}
