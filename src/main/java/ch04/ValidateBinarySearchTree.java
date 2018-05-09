package ch04;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/description/
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (root==null) {
            return true;
        }

        if (min!=null && min>=root.val) {
            return false;
        }

        if (max!=null && max <= root.val) {
            return false;
        }

        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
