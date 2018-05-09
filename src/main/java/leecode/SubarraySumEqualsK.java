package leecode;

public class SubarraySumEqualsK {

    public static void main(String[] args) {
        int[] nums = {100,1,2,3,4};
        System.out.println(new SubarraySumEqualsK().subarraySum(nums, 3));
    }

    public int subarraySum(int[] nums, int k) {

        int slow = 0;
        int fast = 0;

        int currentSum = 0;
        int totalSolution = 0;

        for (int i = 0; i < nums.length; i++) {
            int d = Math.abs(currentSum + nums[i] - k);
            while ( Math.abs(currentSum + nums[i] - nums[slow]-k) < d && slow < i) {
                currentSum -= nums[slow];
                slow++;
                d = Math.abs(currentSum + nums[i] - k);
            }

            if (currentSum + nums[i] == k) {
                totalSolution += 1;
                currentSum -= nums[slow];
                currentSum += nums[i];
                slow++;
            } else if (currentSum + nums[i] < k) {
                fast++;
                currentSum += nums[i];
            } else {
                slow++;
            }
        }

        return totalSolution;
    }

}
