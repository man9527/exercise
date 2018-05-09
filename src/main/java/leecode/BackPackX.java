package leecode;

import java.util.HashMap;

public class BackPackX {

    public static void main(String[] args) {
        System.out.println( new BackPackX().backPackX(9113) );
    }

    public int backPackX(int n) {
        // write your code here
        // 150, 250, 350

        HashMap<Integer, Integer> cache = new HashMap<>();
        int spend = backInternal(n, cache);

        return n-spend;

    }

    public int backInternal(int remaining, HashMap<Integer, Integer> c) {

        if (remaining<150) {
            return 0;
        }

        if (c.get(remaining)!=null) {
            return c.get(remaining);
        }

        int max = Integer.MIN_VALUE;

        if (remaining>=150) {
            int spend150 = backInternal(remaining - 150, c);
            if (spend150 >= 0) {
                max = Math.max(max, 150 + spend150);
            }
        }

        if (remaining>=250) {
            int spend250 = backInternal(remaining - 250, c);
            if (spend250 >= 0) {
                max = Math.max(max, 250 + spend250);
            }
        }

        if (remaining>=350) {
            int spend350 = backInternal(remaining - 350, c);
            if (spend350 >= 0) {
                max = Math.max(max, 350 + spend350);
            }
        }

        c.put(remaining, max);
        return max;
    }

}
