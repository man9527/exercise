package leetcode2;

/**
 * https://leetcode.com/problems/merge-sorted-array/description/
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = {5,10,15,20,25,0,0,0};
        int[] nums2 = {2,13,21};

        new MergeSortedArray().merge(nums1, 5, nums2, 3);
        System.out.println("ok");
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i=m-1;
        int j=n-1;
        int total = m+n-1;
        while (i>=0 && j>=0) {
            if (nums1[i]>=nums2[j]) {
                nums1[total] = nums1[i];
                i--;
            } else {
                nums1[total] = nums2[j];
                j--;
            }

            total = total-1;
        }

        while (j>=0) {
            nums1[total] = nums2[j];
            j--;
            total--;
        }
    }
}
