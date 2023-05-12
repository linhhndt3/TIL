package _75_questions;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromProOrderAndInOrderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> preOrderMap = buildIndexAndValue(preorder);
        Map<Integer,Integer> inOrderMap = buildIndexAndValue(inorder);
        TreeNode root = buildTreeHelper(preorder,inorder,preOrderMap,inOrderMap,
                                        0, preorder.length-1,0, inorder.length-1);
        return root;
    }

    TreeNode buildTreeHelper(int[] preorder, int[] inorder, Map<Integer,Integer> preOrderMap, Map<Integer,Integer> inOrderMap,
                             int startPreIndex, int endPreIndex, int startInOrderIndex, int endInOrderIndex) {
        if(startPreIndex > endPreIndex) {
            return null;
        }
        if(startInOrderIndex > endInOrderIndex) {
            return null;
        }
        if(startPreIndex < 0 || startPreIndex >= preorder.length) {
            return null;
        }
        if(endPreIndex < 0 || endPreIndex >= preorder.length) {
            return null;
        }
        if(startInOrderIndex < 0 || startInOrderIndex >= inorder.length) {
            return null;
        }
        if(endInOrderIndex < 0 || endInOrderIndex >= inorder.length) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[startPreIndex]);

        int indexOfRootInInorder = inOrderMap.get(preorder[startPreIndex]);

        int lengthOfLeftSubTree = indexOfRootInInorder - startInOrderIndex;
        int lengthOfRightSubTree = endInOrderIndex - indexOfRootInInorder;


        if(lengthOfLeftSubTree > 0) {
            int leftStartPreIndex = startPreIndex + 1;
            int leftEndPreIndex = leftStartPreIndex + lengthOfLeftSubTree-1;

            int leftStartInOrderIndex = startInOrderIndex;
            int leftEndInOrderIndex = leftStartInOrderIndex + lengthOfLeftSubTree-1;
            root.left = buildTreeHelper(preorder, inorder, preOrderMap, inOrderMap,
                    leftStartPreIndex, leftEndPreIndex, leftStartInOrderIndex, leftEndInOrderIndex);
        } else {
            root.left = null;
        }
        if(lengthOfRightSubTree > 0) {
            int rightStartPreindex = startPreIndex + lengthOfLeftSubTree + 1;
            int rightEndPreindex = rightStartPreindex + lengthOfRightSubTree - 1;

            int rightStartInOrderIndex = indexOfRootInInorder + 1;
            int rightEndInOrderIndex = rightStartInOrderIndex+lengthOfRightSubTree-1;
            root.right = buildTreeHelper(preorder,inorder,preOrderMap,inOrderMap,
                    rightStartPreindex, rightEndPreindex, rightStartInOrderIndex, rightEndInOrderIndex);
        } else  {
            root.right = null;
        }

        return root;
    }

    Map<Integer,Integer> buildIndexAndValue(int[] order) {
        Map<Integer,Integer> valueAndIndex = new HashMap<>();
        int index = 0;
        while (index < order.length) {
            valueAndIndex.put(order[index],index);
            index++;
        }
        return valueAndIndex;
    }
}