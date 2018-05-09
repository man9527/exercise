package leetcode2;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 */
public class LargestK {

    public static void main(String[] args) {
        int[] nums = {15,27,3,5,7,8,10};
        int result = new LargestK().findKthLargest(nums, 4);
        
        System.out.println(result);
    }

    public int findKthLargest(int[] nums, int k) {

        int start = 0, end = nums.length - 1, index = nums.length - k;

        while (start < end) {
            int pivot = find(nums, start, end);
            if (pivot < index) start = pivot + 1;
            else if (pivot > index) end = pivot - 1;
            else return nums[pivot];
        }
        return nums[start];
    }

    private int find(int[] nums, int begin, int end) {

        if (begin>end) {
            return -1;
        }

        int pivot = begin;

        int i=begin, j=end;

        while(i<j) {
            while(i<nums.length && nums[i]<=nums[pivot]) {
                i++;
            }

            while(j>=0 && nums[pivot]<nums[j]) {
                j--;
            }

            if (i<j) {
                swap(nums, i, j);
            }
        }

        swap(nums, pivot, j);

        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

}
