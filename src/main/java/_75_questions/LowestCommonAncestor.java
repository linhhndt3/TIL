package _75_questions;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val == root.val || q.val == root.val) {
            return root;
        }
        if(p.val < root.val && q.val > root.val) {
            return root;
        }

        if(p.val > root.val && q.val < root.val) {
            return root;
        }
        if(p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left,p,q);
        }
        if(p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right,p,q); // TODO bug because of copy above code so that always loof for left
        }
        return null;
    }
}