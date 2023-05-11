package _75_questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> rs = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        list.add(root.val);
        rs.add(list);
        queue.add(root);
        bfs(queue,rs);
        return rs;
    }

    public void bfs(Queue<TreeNode> queue, List<List<Integer>> rs) {
        if(queue.isEmpty()) {
            return;
        }
        Queue<TreeNode> newQueue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if(node.left != null) {
                list.add(node.left.val);
                newQueue.add(node.left);
            }
            if(node.right != null) {
                list.add(node.right.val);
                newQueue.add(node.right);
            }

        }
        if(list.size() != 0) {
            rs.add(list);
        }
        bfs(newQueue,rs);
    }
}