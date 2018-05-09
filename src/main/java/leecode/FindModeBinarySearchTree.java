package leecode;

/**
 * https://leetcode.com/problems/find-mode-in-binary-search-tree/description/
 */
public class FindModeBinarySearchTree {
    public int[] findMode(TreeNode root) {

        if (root==null) {
            return new int[0];
        }

        int[] left = findMode(root.left);
        int[] right = findMode(root.left);
        
        return null;
    }

    
}
