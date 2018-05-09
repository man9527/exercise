package ch04;

import leecode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        levelOrderInternal(root, result, 0);

        return result;
        
    }

    private void levelOrderInternal(TreeNode root, List<List<Integer>> result, int level) {

        if (result.size()<level+1) {
            result.add(level, new ArrayList<>());
        }

        List<Integer> levelArray = result.get(level);

        levelArray.add(root.val);
        levelOrderInternal(root.left, result, level+1);
        levelOrderInternal(root.right, result, level+1);
    }
    
}
