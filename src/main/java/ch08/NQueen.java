package ch08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NQueen {

    public static void main(String[] args) {
        System.out.println(new NQueen().solveNQueens(2));
    }
    public List<List<String>> solveNQueens(int n) {
        return solveNQueensInternal(n, 0);
    }

    public List<List<String>> solveNQueensInternal(int n, int row) {

        if (row>=n) {
            return Collections.emptyList();
        }

        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j==i)
                    sb.append("Q");
                else
                    sb.append(".");
            }

            List<String> is = new ArrayList<>();
            is.add(sb.toString());
            List<List<String>> subR = solveNQueensInternal(n, row+1);

            for(List<String> l:subR) {
                l.addAll(is);
                result.add(l);
            }
        }

        return result;
    }

}
