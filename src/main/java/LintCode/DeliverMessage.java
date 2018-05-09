package LintCode;

import java.util.ArrayList;
import java.util.Stack;

public class DeliverMessage {

    public static void main(String[] args) {
//        int[] t = {1,2,3};
//        int[][] subs = {{1,2},{-1},{-1}};

//        int[] t = {1,2,1,4,5};
//        int[][] subs = {{1,2},{3,4},{-1},{-1},{-1}};

//        int[] t = {13,30,21,18,20,22,22,5,3,26};
//        int[][] subs = {{3,7},{8},{-1},{5,1},{-1},{4},{-1},{2,6,9},{-1},{-1}};

        int[] t = {20,17,16,30,4,10,18,20,10,30,13,5,22,21,1,16,4,24,3,28,17,6,25,30,18,4,14,2,17,26,10,1,21,3,17,17,11,13,19,18,28,17,5,22,1,7,18,1,9,14};
        int[][] subs = {{21},{-1},{48,1},{31,2,49},{23},{-1},{46,39,28,30},{38},{-1},{-1},{6,4,45,22,15},{-1},{10,27,47,16},{-1},{-1},{-1},{-1},{26},{-1},{42,14},{-1},{33},{-1},{5},{17},{24,7},{-1},{8,13},{-1},{-1},{-1},{11,34,18},{12,41},{35,9},{-1},{32},{-1},{-1},{20,37},{-1},{3},{-1},{-1},{25,29},{-1},{36},{40},{-1},{19,43,44},{-1}};

        System.out.println(new DeliverMessage().deliverMessage(t, subs));
    }

    public int deliverMessage(int[] t, int[][] subordinate) {
        ArrayList<Integer> levelcost= new ArrayList<>();

        deliverMessage(t, subordinate, 0, subordinate[0], 0, levelcost);

        return levelcost.stream().mapToInt(i -> i.intValue()).sum();

    }

    public void deliverMessage(int[] t, int[][] subordinate, int head, int[] subs, int level, ArrayList<Integer> levelcost) {

        if (subs.length==1 && subs[0]==-1) {
            return;
        }

        if (levelcost.size()-1<level) {
            levelcost.add(0);
        }

        levelcost.set(level, Math.max(levelcost.get(level), t[head]));
        for (int i = 0; i < subs.length; i++) {
            deliverMessage(t, subordinate, subs[i], subordinate[subs[i]], level+1, levelcost);
        }

    }


    public int deliverMessage2(int[] t, int[][] subordinate) {
        // Write your code here

        if (t==null || t.length==0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();

        int result = 0;
        stack.push(0);

        while (!stack.empty()) {
            int idx = stack.pop();

            int[] subs = subordinate[idx];

            boolean hasSub = false;
            for (int i = 0; i < subs.length; i++) {
                if(subs[i]!=-1) {
                    hasSub=true;
                    stack.push(subs[i]);
                }
            }

            if (hasSub)
                result+=t[idx];
        }

        return result;
    }
    
}
