package ch04;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

/**
 * http://www.lintcode.com/en/problem/route-between-two-nodes-in-graph/
 */
public class RouteBetweenNode {

    /*
     * @param graph: A list of Directed graph node
     * @param s: the starting Directed graph node
     * @param t: the terminal Directed graph node
     * @return: a boolean value
     */
    public boolean hasRoute(ArrayList<DirectedGraphNode> graph, DirectedGraphNode s, DirectedGraphNode t) {
        // write your code here

        if (s.label==t.label) {
            return true;
        }
        HashSet<Integer> visited = new HashSet<>();
        Stack<DirectedGraphNode> stack = new Stack<>();

        stack.push(s);

        while(!stack.empty()) {
            DirectedGraphNode n = stack.pop();
            visited.add(n.label);
            for(DirectedGraphNode neighbor:n.neighbors) {
                if (neighbor.label==t.label) {
                    return true;
                }
                if (!visited.contains(neighbor.label)) {
                    stack.push(neighbor);
                }
            }

        }

        return false;

    }


    class DirectedGraphNode {
      int label;
      ArrayList<DirectedGraphNode> neighbors;
      DirectedGraphNode(int x) {
          label = x;
          neighbors = new ArrayList<DirectedGraphNode>();
      }
  }
}
