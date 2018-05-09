package leecode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        return innerNonRecursive(root, new ArrayList<>());
    }

    private List<Integer> inner (TreeNode root, List<Integer> result) {

        if (root==null) {
            return result;
        }

        inner(root.left, result);
        result.add(root.val);
        inner(root.right, result);

        return result;
    }


    private List<Integer> innerNonRecursive (TreeNode root, List<Integer> result) {
        if (root==null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();

        populateStack(root, stack);

        while(!stack.empty()) {
            TreeNode t = stack.pop();
            result.add(t.val);

            populateStack(t.right, stack);
        }

        return result;
    }

    private void populateStack(TreeNode root, Stack<TreeNode> stack) {
        while(root!=null) {
            stack.push(root);
            root = root.left;
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);

        n2.left=n3;
        n1.right=n2;

        List<Integer> l = new BinaryTreeInorderTraversal().inorderTraversal(n1);
        System.out.println(l);

    }
}
