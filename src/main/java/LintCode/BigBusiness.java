package LintCode;

import java.util.HashSet;

public class BigBusiness {

    public static void main(String[] args) {
        int[] a = {3,2,5};
        int[] b = {3,1,2};
        System.out.println(new BigBusiness().bigBusiness(a, b, 100));
    }

    public int bigBusiness(int[] a, int[] b, int k) {
        // Write your code here

        HashSet<Integer> bought = new HashSet<>();

        while (bought.size()<a.length) {
            HashSet<Integer> tobuy = new HashSet<>();
            for (int i = 0; i < a.length; i++) {
                if (!bought.contains(i) && a[i]<=k && b[i]>a[i]) {
                    tobuy.add(i);
                }
            }

            if (tobuy.size()==0) {
                break;
            }

            for(Integer idx: tobuy) {
                if (a[idx]<=k) {
                    k -= a[idx];
                    k += b[idx];
                    bought.add(idx);
                }
            }
        }

        return k;
    }
    
}
