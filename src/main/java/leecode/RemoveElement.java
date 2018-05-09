package leecode;

/**
 * https://leetcode.com/problems/remove-element/description/
 */
public class RemoveElement {

    public static int removeElement(int[] nums, int val) {

        int uniqueLength = -1;

        for (int i=0; i<nums.length; i++) {
            if (val != nums[i]) {
                uniqueLength++;
                if (nums[i]!=nums[uniqueLength]) {
                    nums[uniqueLength]=nums[i];
                }
            }
        }

        return uniqueLength+1;
    }

    public static void main(String args[]) {
        int[] nums = {3,2,1,5,2,6,7};
        System.out.println(removeElement(nums, 2));
        System.out.println(nums);

    }
}
