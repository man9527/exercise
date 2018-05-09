package ch04;

import leecode.TreeNode;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {

        if (root==null) {
            return false;
        }

        if (root.val==sum && (root.left==null && root.right==null)) {
            return true;
        }

        if (root.left==null) {
            return hasPathSumInternal(root.right, sum-root.val);
        } else if (root.right==null) {
            return hasPathSumInternal(root.left, sum-root.val);
        }

        return hasPathSumInternal(root.left, sum-root.val) || hasPathSumInternal(root.right, sum-root.val);

    }


    public boolean hasPathSumInternal(TreeNode root, int sum) {

        if (root==null && sum!=0) {
            return false;
        }

        if (root==null && sum==0) {
            return true;
        }

        if (root.left==null) {
            return hasPathSumInternal(root.right, sum-root.val);
        } else if (root.right==null) {
            return hasPathSumInternal(root.left, sum-root.val);
        }

        return hasPathSumInternal(root.left, sum-root.val) || hasPathSumInternal(root.right, sum-root.val);
    }

}
