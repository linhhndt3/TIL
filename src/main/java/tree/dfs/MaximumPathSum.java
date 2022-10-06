package tree.dfs;


import java.util.HashMap;
import java.util.Map;

public class MaximumPathSum {
    public int maxPathSum(TreeNode root) {
        return findDiameterHelper(root);
    }

    public int findDiameterHelper(TreeNode node) {
        // TODO: Write your code here

        int d1 = node.val;
        if(node.left != null) {
            int d1left = findLongestPath(node.left, 0, node.left.val);
            if(d1left > 0) {
                d1 += d1left;
            }
        }

        if(node.right != null) {
            int d1right = findLongestPath(node.right, 0, node.right.val);
            if(d1right > 0) {
                d1 += d1right;
            }
        }

        if(node.left != null) {
            int d2 = findDiameterHelper(node.left);
            d1 = findMax(d1,d2);
        }

        if(node.right != null) {
            int d2 = findDiameterHelper(node.right);
            d1 = findMax(d1,d2);
        }

        return d1;
    }

    private int findLongestPath(TreeNode node, int sum, int max) {
        if(node == null) {
            return max;
        }

        sum = sum + node.val;
        max = max > sum ? max : sum;
        // path.add(node);

        int m1 = findLongestPath(node.left, sum, max);
        int m2 = findLongestPath(node.right, sum, max);
        // path.remove(path.size() - 1);
        return m1 > m2 ? m1 : m2;
    }

    private static void findLongestPathBacktracking(TreeNode node, Map<TreeNode,Integer> rs) {
        if(node == null) {
            return;
        }
        if(rs.get(node) != null) {
            return;
        }
        int val = node.val;
        if(node.left == null && node.right == null) {
            rs.put(node,val);
            return;
        }
        // path.add(node);
        if(rs.get(node.left) == null) {
            findLongestPathBacktracking(node.left, rs);
        }

        if(rs.get(node.right) == null) {
            findLongestPathBacktracking(node.right, rs);
        }

        rs.put(node, findMax(val,val+rs.get(node.left),val+rs.get(node.right)));

    }

    private static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    private static int findMax(int a, int b) {
        return a > b ? a : b;
    }

    private static int findMax(int a, int b, int c) {
        int max1 = a > b ? a : b;
        return max1 > c ? max1 : c;
    }

    public static void main(String[] args) {
        Map<TreeNode,Integer> rs = new HashMap<>();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
//        MaximumPathSum.findLongestPathBacktracking(root, rs);
//        System.out.println(rs);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
//        root.right.left.left = new TreeNode(7);
//        root.right.left.right = new TreeNode(8);
//        root.right.right.left = new TreeNode(9);
        MaximumPathSum.findLongestPathBacktracking(root, rs);
        System.out.println(rs);
//
//        root = new TreeNode(-1);
//        root.left = new TreeNode(-3);
//        System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));
    }
}
