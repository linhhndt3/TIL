package _recall_75_questions;

public class _98_ValidateBinarySearch {
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
        while(node.right != null) {
            node = node.right;
        }
        return node.val < val;
    }

    public boolean isGreaterThan(TreeNode node, int val) {
        if(node == null) {
            return true;
        }
        while(node.left != null) {
            node = node.left;
        }
        return node.val > val;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TreeNode)) return false;
        TreeNode treeNode = (TreeNode) o;
        return this == treeNode;
    }

}