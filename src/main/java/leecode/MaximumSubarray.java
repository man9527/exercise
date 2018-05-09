package leecode;

public class MaximumSubarray {

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new MaximumSubarray().maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        int currentMax = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (currentMax <0) {
                currentMax = nums[i];
            } else {
                currentMax = currentMax + nums[i];
            }

            max = Math.max(max, currentMax);
        }

        return max;
    }

}
