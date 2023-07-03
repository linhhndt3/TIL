package _75_questions;

public class _543_DiameterOfBinaryTree {

    int max = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        diameterOfBinaryTreeHelper(root);
        return max;
    }

    public int diameterOfBinaryTreeHelper(TreeNode node) {

        if(isALeaf(node)) {
            max = Math.max(max,0);
            return 0;
        }

        int maxLeft = node.left != null ? 1 + diameterOfBinaryTreeHelper(node.left) : 0;
        int maxRight = node.right != null ? 1 + diameterOfBinaryTreeHelper(node.right) : 0;

        max = Math.max(max,maxLeft + maxRight);
        return Math.max(maxLeft,maxRight);
    }

    private boolean isALeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }

}