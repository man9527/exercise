package leecode;

public class DiameterBinaryTree {

    public int diameterOfBinaryTree(TreeNode root) {
        diameterOfBinaryTreeRec(root);
        return diameter;
    }

    int diameter = Integer.MIN_VALUE;

    public int diameterOfBinaryTreeRec(TreeNode root) {
        if (root==null) {
            return 0;
        }

        int leftH = diameterOfBinaryTreeRec(root.left);
        int rightH = diameterOfBinaryTreeRec(root.right);

        diameter = Math.max(diameter, leftH+rightH);

        return Math.max(leftH+1, rightH+1);


    }
}
