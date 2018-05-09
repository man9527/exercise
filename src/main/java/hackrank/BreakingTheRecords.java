package hackrank;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem
 */
public class BreakingTheRecords {

    static int[] breakingRecords(int[] score) {
        // Complete this function

        int max = score[0];
        int min = score[0];

        int high=0, low = 0;

        for(int i=1; i<score.length; i++) {

            if (score[i]>max) {
                high++;
                max = score[i];
            } else if (score[i]<min) {
                low++;
                min = score[i];
            }


        }

        int[] result = {high, low};
        return result;
    }

    public static void main(String[] args) {

        Map<String, List<Integer>> usersNumbersMap = new HashMap<String, List<Integer>>();

        ArrayList<Integer> a = new ArrayList<>();
        usersNumbersMap.put("aa", a);
        

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] score = new int[n];
        for(int score_i = 0; score_i < n; score_i++){
            score[score_i] = in.nextInt();
        }
        int[] result = breakingRecords(score);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }

}
