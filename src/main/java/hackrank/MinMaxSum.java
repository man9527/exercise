package hackrank;

import java.math.BigDecimal;
import java.util.Scanner;

public class MinMaxSum {

    static void miniMaxSum(int[] arr) {

        int min = arr[0];
        int max = arr[0];
        BigDecimal minSum = new BigDecimal(arr[0]);

        for (int i=1; i<arr.length; i++) {

            if (arr[i] < min) {
                min = arr[i];
            } else if (arr[i] > max) {
                max = arr[i];
            }

            minSum = minSum.add(new BigDecimal(arr[i]));
        }

        System.out.println(minSum.subtract(new BigDecimal(max)) + " " + minSum.subtract(new BigDecimal(min)));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[5];
        for(int arr_i = 0; arr_i < 5; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        miniMaxSum(arr);
        in.close();
    }

}
