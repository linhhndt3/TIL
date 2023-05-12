package _75_questions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class KthSmallestElementInABST {
    // note
    // tree & graph that use dfs, pls take an simple example, then draw the function recursively so that an intuition come

    public int kthSmallest(TreeNode root, int k) {
        Stack<Integer> stack = new Stack<>();
        kthSmallestHelper(root,stack,k);
        return stack.peek();
    }

    public void kthSmallestHelper(TreeNode node, Stack<Integer> stack, int k) {
        if(node == null) {
            return;
        }
        if(stack.size() == k) {
            return;
        }
        kthSmallestHelper(node.left,stack,k);
        if(stack.size() < k) {
            stack.add(node.val);
        }
        kthSmallestHelper(node.right,stack,k);
    }
}