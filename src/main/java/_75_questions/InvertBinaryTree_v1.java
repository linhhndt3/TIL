package _75_questions;

public class InvertBinaryTree_v1 {
    public TreeNode invertTree(TreeNode root) {
        if(root==null) {
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;

        invertTree(left);
        invertTree(right);
        root.left = right;
        root.right = left;
        return root;
    }
}