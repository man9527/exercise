package leecode;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 */
public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {

        int j=0;

        for (int i = 1; i < nums.length ; i++) {
            if (nums[i]!=nums[i-1]) {
                j++;
                if (nums[i]!=nums[j]) {
                    nums[j]=nums[i];
                }
            }

        }

        return j+1;
    }

    public static void main(String[] args) {
        int[] n = {1,1,1,2,2,3,3,3,4,5,6,7,8};
        System.out.println(removeDuplicates(n));
    }
}
