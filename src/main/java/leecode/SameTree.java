package leecode;

import sun.reflect.generics.tree.Tree;

import java.util.Stack;

/**
 * https://leetcode.com/problems/same-tree/description/
 */
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> ps = new Stack<>();
        Stack<TreeNode> pg = new Stack<>();

        ps.push(p);
        pg.push(q);

        while(!ps.empty()) {
            if (pg.empty()) return false;

            TreeNode ns = ps.pop();
            TreeNode nq = pg.pop();

            if (ns==null && nq==null) {
                continue;
            }

            if (ns!=null && nq==null) {
                return false;
            }

            if (ns==null && nq!=null) {
                return false;
            }

            if (ns.val!=nq.val) {
                return false;
            }

            ps.push(ns.left); ps.push(ns.right);
            pg.push(nq.left); pg.push(nq.right);
        }

        if (!pg.empty()) {
            return false;
        }

        return true;
    }

}
