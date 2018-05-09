package leecode;

import java.util.HashMap;

public class SoupServings {

    public static void main(String[] args) {
        System.out.println(new SoupServings().soupServings(20));
    }
    public double soupServings(int N) {
        return soupServingsInternal(N, N, new HashMap<>());
    }


    public double soupServingsInternal(int NA, int NB, HashMap<Integer, Double> cache) {

        if (NA==NB && NA<=0) {
            return 0.5;
        }

        if (NA>0 && NB<=0) {
            return 0;
        }

        if (NA<=0) {
            return 1;
        }

        double result = 0.25 * soupServingsInternal(NA-100, NB, cache) +
                        0.25 * soupServingsInternal(NA-75, NB-25, cache) +
                        0.25 * soupServingsInternal(NA-50, NB-50, cache) +
                        0.25 * soupServingsInternal(NA-25, NB-75, cache);

        return result;
    }

    public double soupServingsInternalRec(int N, HashMap<Integer, Double> cache) {

        if (N<=0) {
            return 1.0;
        }
        if (cache.get(N)!=null) {
            return cache.get(N);
        }

        double result = 0.25 * soupServingsInternalRec(N-100, cache) +
                0.25 * soupServingsInternalRec( N-75, cache) +
                0.125 * soupServingsInternalRec(N-50, cache) +
                0.25 * soupServingsInternalRec(N-25, cache);

        cache.put(N, result);
        return result;
    }


}
