package _75_questions;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeMaximumPathSum {
    // rough id
    // if we know the max path of root.left and root.right, we can get the max path sum

    // TODO
    // identified and detected that the rough idea(intuition) is not correct

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

        int maxSeperatePath = Math.max(maxLeft + currentVal, maxRight + currentVal);
        max = findMax(max,maxSeperatePath, currentVal,maxLeft + maxRight + currentVal, maxLeft,maxRight);
        return maxSeperatePath;
    }

    boolean isALeaf(TreeNode node) {
        if(node.left == null && node.right == null) {
            return true;
        }
        return false;
    }

    int findMax(Integer... args) {
        int max = Integer.MIN_VALUE;
        for(Integer arg : args) {
            if(arg >= max) {
                max = arg;
            }
        }
        return max;
    }

}