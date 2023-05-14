package _75_questions;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeMaximumPathSum {
    // rough id
    // if we know the max path of root.left and root.right, we can get the max path sum
    public int maxPathSum(TreeNode root) {
        int maxSum = Integer.MIN_VALUE;
        Map<TreeNode,Integer> maxPathSum = new HashMap<>();
        Map<TreeNode,Integer> maxPathIncludeRoot = new HashMap<>();
        maxPathSumHelper(root,maxPathSum,maxPathIncludeRoot);
        for(Map.Entry<TreeNode,Integer> entry : maxPathSum.entrySet()) {
            if(entry.getValue() > maxSum) {
                maxSum = entry.getValue();
            }
        }
        return maxSum;
    }

    void maxPathSumHelper(TreeNode node, Map<TreeNode,Integer> maxPathSum, Map<TreeNode,Integer> maxPathIncludeRoot) {
        if(node == null) {
            return;
        }
        if(isALeaf(node)) {
            maxPathIncludeRoot.put(node,node.val);
            maxPathSum.put(node,node.val);
            return;
        }

        maxPathSumHelper(node.left,maxPathSum,maxPathIncludeRoot);
        maxPathSumHelper(node.right,maxPathSum,maxPathIncludeRoot);

        int currentVal = node.val;

        int maxPathIncludeRootLeft = maxPathIncludeRoot.getOrDefault(node.left,Integer.MIN_VALUE);
        int maxPathIncludeRootRight = maxPathIncludeRoot.getOrDefault(node.right,Integer.MIN_VALUE);

        int maxPathSumLeft = maxPathSum.getOrDefault(node.left,Integer.MIN_VALUE);
        int maxPathSumRight = maxPathSum.getOrDefault(node.right,Integer.MIN_VALUE);

        int maxPathIncludeCurrentNode = -1;
        int maxPathIncludeLeftAndRight= -1;
        if(maxPathIncludeRootLeft != Integer.MIN_VALUE && maxPathIncludeRootRight != Integer.MIN_VALUE) {
            maxPathIncludeCurrentNode = findMax(currentVal + maxPathIncludeRootLeft,currentVal + maxPathIncludeRootRight);
            maxPathIncludeLeftAndRight = findMax(currentVal+maxPathIncludeRootLeft+maxPathIncludeRootRight, maxPathIncludeCurrentNode);
        } else if(maxPathIncludeRootLeft == Integer.MIN_VALUE && maxPathIncludeRootRight != Integer.MIN_VALUE) {
            maxPathIncludeCurrentNode = findMax(currentVal, currentVal + maxPathIncludeRootRight);
        } else if(maxPathIncludeRootLeft != Integer.MIN_VALUE && maxPathIncludeRootRight == Integer.MIN_VALUE) {
            maxPathIncludeCurrentNode = findMax(currentVal,currentVal+ maxPathIncludeRootLeft);
        } else {
            maxPathIncludeCurrentNode = currentVal;
        }
        maxPathIncludeRoot.put(node,maxPathIncludeCurrentNode);

        int maxPathSumOfCurrentNode = findMax(maxPathIncludeCurrentNode,maxPathIncludeLeftAndRight, maxPathSumLeft,maxPathSumRight);
        maxPathSum.put(node, maxPathSumOfCurrentNode);

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