package _recall_75_questions;

public class _124_BinaryTreeMaximumPathSum {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return max;
    }

    int maxPathSumHelper(TreeNode node) {
        if(node == null) {
            return 0;
        }
        if(isALeaf(node)) {
            max = Math.max(max,node.val);
            return node.val;
        }

        int maxLeft = maxPathSumHelper(node.left);
        int maxRight = maxPathSumHelper(node.right);

        int currentVal = node.val;

        int maxSeperatePath = findMax(maxLeft + currentVal, maxRight + currentVal,currentVal);
        max = findMax(max,maxSeperatePath,maxLeft + maxRight + currentVal,currentVal);
        return maxSeperatePath;
    }

    boolean isALeaf(TreeNode node) {
        if(node.left == null && node.right == null) {
            return true;
        }
        return false;
    }

    int findMax(Integer... args) {
        int max = args[0];
        for(Integer arg : args) {
            if(arg >= max) {
                max = arg;
            }
        }
        return max;
    }
}