package _75_questions;

public class MaximimDepthOfTree_v1 {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftMax = 1 + maxDepth(root.left);
        int rightMax = 1 + maxDepth(root.right);
        return leftMax >= rightMax ? leftMax : rightMax;
    }
}