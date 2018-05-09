package leecode;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 */
public class RemoveDuplicatesII {

    public static int removeDuplicates(int[] nums) {

        int count=1;
        int j=0;

        for (int i = 1; i < nums.length ; i++) {
            if (nums[i]!=nums[i-1]) {
                j++;
                count=1;
                if (nums[i]!=nums[j]) {
                    nums[j]=nums[i];
                }
            } else if (count<2) {
                j++;
                count++;
                if (nums[i]!=nums[j]) {
                    nums[j]=nums[i];
                }
            } else {
                count++;
            }

        }

        return j+1;
    }

    public static void main(String[] args) {
        int[] n = {1,1,1,1,3,3,3};
        System.out.println(removeDuplicates(n));
    }
}
