package leetcode3;

import leecode.TreeNode;

public class BinaryTreePruning {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(0);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(0);
        TreeNode n5 = new TreeNode(0);
        TreeNode n6 = new TreeNode(0);
        TreeNode n7 = new TreeNode(1);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        TreeNode n8 = new BinaryTreePruning().pruneTree(n1);

        System.out.println(n8);

    }

    public TreeNode pruneTree(TreeNode root) {
        return pruneTreeRec(root);
    }

    public TreeNode pruneTreeRec(TreeNode root) {

        if (root==null) {
            return null;
        }

        TreeNode left = pruneTreeRec(root.left);
        TreeNode right = pruneTreeRec(root.right);

        if (left==null && right==null && root.val==0) {
            return null;
        } else {
            root.left=left;
            root.right=right;
            return root;
        }
        
    }


}
