package _75_questions;

public class _110_BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isBalanced(root.left) && isBalanced(root.right)
                && Math.abs(heightOfTree(root.left) - heightOfTree(root.right)) <= 1;
    }

    private int heightOfTree(TreeNode node) {
        if(node == null) {
            return 0;
        }
        return Math.max(1 + heightOfTree(node.left), 1 + heightOfTree(node.right));
    }
}