package hackrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/day-of-the-programmer/problem
 */
public class DayOfTheProgrammer {

    static String solve(int year){
        int dotp=256;
        // Complete this function
        int[] yeardays = {31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int daysOfFeb = 0;
        if (year == 1918) {
            daysOfFeb = 28-14+1;
        } else if (year<1918) {
            daysOfFeb = year%4==0?29:28;
        } else {
            daysOfFeb = (year%4==0&&year%100!=0 || year%400==0)?29:28;
        }

        yeardays[1]=daysOfFeb;

        int remaing = dotp;
        int i=0;
        for (; i < yeardays.length && remaing>yeardays[i]; i++) {
            remaing-=yeardays[i];
        }

        StringBuilder result = new StringBuilder();
        result.append(remaing);
        result.append(".");
        if (i<9) {
            result.append("0" + (i+1));
        } else {
            result.append(i+1);
        }
        result.append("." + year);

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int year = in.nextInt();
        String result = solve(year);
        System.out.println(result);
    }
}
