package leecode;

import java.util.Arrays;
import java.util.HashSet;

public class IntersectionTwoArrays {

    public static void main(String[] args) {
        int[] nums1 = {2,1};
        int[] nums2 = {1,2};
        int[] r = (new IntersectionTwoArrays().intersection(nums1, nums2));
        System.out.println(r.length);
    }

    public int[] intersection(int[] nums1, int[] nums2) {

        if (nums1==null && nums1.length==0) {
            return new int[0];
        }

        if (nums2==null && nums2.length==0) {
            return new int[0];
        }

        int[] longa = (nums1.length>=nums2.length)?nums1:nums2;
        int[] shorta = (nums1.length<nums2.length)?nums1:nums2;

        HashSet<Integer> cache = new HashSet<>();
        Arrays.sort(longa);
        Arrays.sort(shorta);
        for (int i = 0; i < shorta.length; i++) {
            if (!cache.contains(shorta[i]) && binarySearch(shorta[i], longa, 0, longa.length-1)) {
                cache.add(shorta[i]);
            }
        }

        int[] result = new int[cache.size()];

        int idx = 0;
        for (Integer i:cache) {
            result[idx]=i;
            idx++;
        }

        return result;
    }

    private boolean binarySearch(int i, int[] array, int begin, int end) {

        if (begin>end) {
            return false;
        }

        int mid = (begin+end)/2;

        if (i==array[mid]) return true;

        if (i<array[mid]) {
            return binarySearch(i, array, begin, mid-1);
        } else {
            return binarySearch(i, array, mid+1, end);
        }

    }
}
