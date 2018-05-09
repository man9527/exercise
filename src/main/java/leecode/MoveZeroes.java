package leecode;

public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = {1,0,1};
        new MoveZeroes().moveZeroes(nums);
        System.out.println(nums);
    }

    public void moveZeroes(int[] nums) {

        int nonzeroIndex = 0;
        int zeroIndex = 0;

        while(nonzeroIndex<nums.length && zeroIndex<nums.length) {
            while ( nonzeroIndex<nums.length && nums[nonzeroIndex]==0) {
                nonzeroIndex++;
            }

            while ( zeroIndex<nums.length && nums[zeroIndex]!=0 ) {
                zeroIndex++;
            }

            if (zeroIndex<nonzeroIndex && nonzeroIndex<nums.length && zeroIndex<nums.length) {
                swap(nums, nonzeroIndex, zeroIndex);
            } else {
                nonzeroIndex++;
            }
        }


    }

    private void swap(int[] nums, int nonzeroIndex, int zeroIndex) {
        int t = nums[nonzeroIndex];
        nums[nonzeroIndex]=0;
        nums[zeroIndex] = t;
    }

}
