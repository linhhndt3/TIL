package _75_questions;

public class SubtreeOfAnotherTree_v1 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        boolean sameFromRoot = isSameTree(root,subRoot);
        if(!sameFromRoot) {
            if(root == null) {
                return false;
            }
            boolean sameFromLeft =  isSubtree(root.left,subRoot); // used to check isSameTree
            if(!sameFromLeft) {
                boolean sameFromRight = isSubtree(root.right,subRoot);
                return sameFromRight;
            } else {
                return sameFromLeft;
            }

        } else {
            return sameFromRoot;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if((p != null && q == null) || (p == null && q != null)) {
            return false;
        }
        if(p == null && q == null) {
            return true;
        }
        if(p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
    }
}