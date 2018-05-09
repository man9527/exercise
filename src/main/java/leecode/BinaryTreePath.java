package leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinaryTreePath {

    public List<String> binaryTreePaths(TreeNode root) {

        if (root==null) {
            return Collections.emptyList();
        }

        if (root.left==null && root.right==null) {
            return Arrays.asList( String.valueOf(root.val) );
        }

        List<String> leftChild = binaryTreePaths(root.left);
        List<String> rightChild = binaryTreePaths(root.right);

        List<String> result = new ArrayList<>();

        for(String s:leftChild) {
            result.add(root.val+ "->" +s);
        }
        for(String s:rightChild) {
            result.add(root.val+ "->" +s);
        }

        return result;
    }

}
