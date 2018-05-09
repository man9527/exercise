package leecode;

import java.util.HashMap;
import java.util.Map;

public class BackpackII {

    public static void main(String[] args) {
        int[] A = {77,22,29,50,99};
        int[] V = {92,22,87,46,90};

        System.out.println(new BackpackII().backPackII(100, A, V));
    }
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @param V: Given n items with value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int[] V) {
        HashMap<Integer, Integer> cache = new HashMap<>();
        boolean[] idx = new boolean[A.length];
        //for (int i = 1; i <= m; i++) {
            backPackInternal(m, A, V, cache, idx, 0);
        //}

        return cache.get(m);
    }

    public int backPackInternal(int m, int[] A, int[] V, Map<Integer, Integer> cache, boolean[] idx, int currentValue) {

        if (m==0) {
            return currentValue;
        }

        if (cache.get(m)!=null) {
            return cache.get(m);
        }

        int max = 0;
        String cacheKey = "";
        for (int i = 0; i < A.length; i++) {
            if (!idx[i]) {
                idx[i]=true;
                int subs = 0;
                if (m-A[i]>=0) {
                    subs = backPackInternal(m - A[i], A, V, cache, idx, currentValue + V[i]);
                    if (subs>max) {
                        max = subs;

                    }
                }
                idx[i]=false;
            }
        }

        if (cache.get(m)==null) {
            cache.put(m, max);
        }
        return max;
    }
}
