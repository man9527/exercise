package leetcode2;

import leecode.TreeNode;

public class ValidBST {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, Integer small, Integer big) {

        if (small!=null && root.val<small) {
            return false;
        }

        if (big!=null && root.val>big) {
            return false;
        }

        return isValidBST(root.left, small, root.val) && isValidBST(root.right, root.val, big);

    }
}
