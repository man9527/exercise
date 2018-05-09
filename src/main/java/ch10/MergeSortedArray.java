package ch10;

public class MergeSortedArray {

    public static void main(String[] args) {
        int[] n1 = {1,0};
        int[] n2 = {2};
        
        merge(n1, 1, n2, 1);
        System.out.println(n1);
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int total = m+n-1;
        m--; n--;
        while(m>=0 && n>=0) {
            if (nums1[m]>=nums2[n]) {
                nums1[total]=nums1[m];
                m--;
            } else {
                nums1[total]=nums2[n];
                n--;
            }
            total--;
        }

        while(n>=0) {
            nums1[n]=nums2[n];
            n--;
        }

    }
    
}
