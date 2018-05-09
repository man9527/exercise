package leecode;

import java.util.HashSet;

public class IntersectionTwoArrays2 {

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

        System.out.println(new IntersectionTwoArrays2().intersection(nums1, nums2));
    }

    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> nums1Set = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {

            nums1Set.add(nums1[i]);

        }

        HashSet<Integer> result = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (nums1Set.contains(nums2[i])) {
                result.add(nums2[i]);
            }
        }

        int[] resultA = new int[result.size()];

        int idx = 0;
        for (Integer i:result) {
            resultA[idx]=i;
            idx++;
        }

        return resultA;

    }


}
