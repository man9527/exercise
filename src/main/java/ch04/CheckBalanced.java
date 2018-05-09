package ch04;

import leecode.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * https://leetcode.com/problems/balanced-binary-tree/description/
 */
public class CheckBalanced {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);

        n1.left=n2;
        n2.left=n3;
        n3.left=n4;
        n4.left=n5;
        n5.left=n6;

        new CheckBalanced().isBalanced(n1);
    }

    public boolean isBalanced(TreeNode root) {
        if (root==null) {
            return true;
        }

        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return left!=-1 && right!=-1 && Math.abs(left-right)<=1;

    }

    private int getHeight(TreeNode root) {

        if (root==null) return 0;

        int left = getHeight(root.left);
        int right = getHeight(root.right);

        if (left==-1 || right==-1 || Math.abs(left-right)>1) {
            return -1;
        }

        return Math.max(left, right)+1;

    }
}
