package _75_questions;

public class ValidBinarySearchTree {
    // TODO enhancement about runtime
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(root.left != null && root.left.val >= root.val) {
            return false;
        }

        if(root.right != null && root.right.val <= root.val) {
            return false;
        }

        return isValidBST(root.left) && isLessThan(root.left, root.val)
                && isValidBST(root.right) && isGreaterThan(root.right, root.val);
    }

    public boolean isLessThan(TreeNode node, int val) {
        if(node == null) {
            return true;
        }
        return node.val < val && isLessThan(node.left, val) && isLessThan(node.right, val);
    }

    public boolean isGreaterThan(TreeNode node, int val) {
        if(node == null) {
            return true;
        }
        return node.val > val && isGreaterThan(node.left, val) && isGreaterThan(node.right, val);
    }
}