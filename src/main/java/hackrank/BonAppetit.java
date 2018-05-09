package hackrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/bon-appetit/problem
 */
public class BonAppetit {

    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        int totalDishes = in.nextInt();
        int skppiedDish = in.nextInt();

        int total = 0;
        for(int ar_i = 0; ar_i < totalDishes; ar_i++){
            if (ar_i!=skppiedDish) {
                total += in.nextInt();
            } else {
                in.nextInt();
            }
        }

        int paid = in.nextInt();

        System.out.println( paid-total/2 == 0? "Bon Appetit": paid-total/2);
    }
}
