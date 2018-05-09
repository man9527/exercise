package hackrank;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * https://www.hackerrank.com/challenges/grading/problem
 */
public class GradingStudents {


    static int[] solve(int[] grades){

        int[] result = Arrays.stream(grades).map(i -> {
            if (i<38 || (i%5)<3) {
                return i;
            } else {
                return i/5 * 5 + 5;
            }
        }).boxed().mapToInt(i->i).toArray();

        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] grades = new int[n];
        for(int grades_i=0; grades_i < n; grades_i++){
            grades[grades_i] = in.nextInt();
        }
        int[] result = solve(grades);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");


    }

}
