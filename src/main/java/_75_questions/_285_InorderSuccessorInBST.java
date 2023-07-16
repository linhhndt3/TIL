package _75_questions;

public class _285_InorderSuccessorInBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(p.right != null) {
            return p.right;
        }

        TreeNode rs = null;
        TreeNode current = root;
        while(current != null) {
            if(current.val > p.val) {
                rs = current;
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return rs;
    }
}