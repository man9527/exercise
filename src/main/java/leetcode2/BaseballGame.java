package leetcode2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BaseballGame {

    public static void main(String[] args) {
        String[] ops = {"5","-2","4","C","D","9","+","+"};
        
        System.out.println( new BaseballGame().calPoints(ops));
    }

    public int calPoints(String[] ops) {

        Stack<String> stack = new Stack<>();

        for (int i = ops.length-1; 0<=i; i--) {
            stack.push(ops[i]);
        }

        LinkedList<Integer> opss = new LinkedList<>();

        while(!stack.empty()) {

            String op = stack.pop();

            if (op.equals("C")) {
                opss.removeLast();
            } else if (op.equals("D")) {
                opss.addLast( opss.getLast()*2);
            } else if (op.equals("+")) {
                opss.addLast( opss.get(opss.size()-2) + opss.getLast());
            } else {
                opss.addLast(Integer.parseInt(op));
            }

        }

        return opss.stream().mapToInt(i->i.intValue()).sum();

    }

}
