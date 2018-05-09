package leetcode3;

import java.util.HashMap;

public class LargestSumAverages {

    public static void main(String[] args) {
        // int[] A = {4663,3020,7789,1627,9668,1356,4207,1133,8765,4649,205,6455,8864,3554,3916,5925,3995,4540,3487,5444,8259,8802,6777,7306,989,4958,2921,8155,4922,2469,6923,776,9777,1796,708,786,3158,7369,8715,2136,2510,3739,6411,7996,6211,8282,4805,236,1489,7698};
        int[] A = {9,1,2,3,9};
        System.out.println(new LargestSumAverages().largestSumOfAverages(A, 3));
    }

    public double largestSumOfAverages(int[] A, int K) {

        return largestSumOfAverages(A, 0, K, new HashMap<>());
    }

    public double largestSumOfAverages(int[] A, int start, int K, HashMap<String, Double> cache) {

        String key = start+"_"+K;
        if (cache.get(key)!=null) {
            return cache.get(key);
        }

        if (start>=A.length) {
            return 0;
        }

        if (K==1) {
            double sum = 0;
            double count = 0;
            for (int i = start; i < A.length; i++) {
                sum += A[i];
                count++;
            }
            double r = sum/count;
            return r;
        }

        double max = 0;

        double currentSum = 0;
        double currentCount = 0;
        for (int i = start; i < A.length; i++) {
            currentSum+=A[i];
            currentCount++;
            double sum = largestSumOfAverages(A, i+1, K-1, cache);
            max = Math.max(max, currentSum/currentCount + sum);
        }


        cache.put(key, max);
        return max;
    }

}
