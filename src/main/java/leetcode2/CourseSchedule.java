package leetcode2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CourseSchedule {

    public static void main(String[] args) {
        int[][] courses = {{1,0},{2,0},{3,1},{3,2}};
        System.out.println(new CourseSchedule().findOrder(4, courses));
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        boolean[] hasdependency = new boolean[numCourses];
        
        HashMap<Integer, Node> map = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {
            int[] path = prerequisites[i];
            int from = path[1];
            int to = path[0];
            Node n = map.get(from);
            if (n==null) {
                n = new Node();
                n.val = from;
                map.put(from, n);
            }

            Node ton = map.get(to);
            if (ton==null) {
                ton = new Node();
                ton.val = to;
                map.put(to, ton);
            }

            n.neighbors.add(to);
            hasdependency[to] = false;
        }

        Node root = null;

        for (int i = 0; i < hasdependency.length; i++) {
            if (!hasdependency[i]) {
                root = map.get(i);
                break;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        traverse(root, map, result);

        int[] ra = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
          ra[i]=result.get(i);
        }

        return ra;
    }

    void traverse(Node root, HashMap<Integer, Node> map, ArrayList<Integer> reuslt) {

        if (root==null) {
            return;
        }

        reuslt.add(root.val);

        for (int i = 0; i < root.neighbors.size(); i++) {
            traverse(map.get(root.neighbors.get(i)), map, reuslt);
        }

    }

    class Node {
        int val;
        boolean dependant;
        List<Integer> neighbors = new ArrayList<>();
    }
}
