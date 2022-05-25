package com.ds.tree;

public class TreeOperations {

    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return root;
        }
        if(root.left == null && root.right ==null) {
            return root;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), null));
        TreeOperations to = new TreeOperations();
        int maxSUm = to.maxProduct(root);
        System.out.println(maxSUm);
    }


//    final long M = 1000000007;
    long res = 0;
    long total(TreeNode node) {
        if (node == null) return 0;
        long l = total(node.left);
        long r = total(node.right);
        long s = l + r + node.val;
        return s;
    }
    long sum(TreeNode node, long total) {
        if (node == null) return 0;
        long l = sum(node.left, total);
        long r = sum(node.right, total);
        long s = l + r + node.val;
        long temp = s * (total - s);
        res = Math.max(res, temp);
        return s;
    }

    int maxProduct(TreeNode root) {
        long total = total(root);
        sum(root, total);
        return (int) (res % 1000000007);
    }

}
