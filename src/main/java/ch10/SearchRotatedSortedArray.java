package ch10;

public class SearchRotatedSortedArray {

    public static void main(String[] args) {
        int[] a = {3,5,1};
        System.out.println(new SearchRotatedSortedArray().search(a, 1));
    }

    public int search(int[] nums, int target) {
        return searchInternal(nums, target, 0, nums.length-1);
    }


    public int searchInternal(int[] nums, int target, int start, int end) {


        if (start>=end && nums[start]==target) {
            return start;
        } else if (start>=end) {
            return -1;
        }

        int middle = (start+end)/2;

        if (nums[middle]==target) {
            return middle;
        }

        if (nums[start]==nums[middle]) {
            return searchInternal(nums, target, middle+1, end);
        }

        if (nums[end]==nums[middle]) {
            return searchInternal(nums, target, start, middle-1);
        }


        if (nums[start]<nums[middle]) {
            if (target<nums[middle] && nums[start]<=target) {
                return searchInternal(nums, target, start, middle-1);
            } else {
                return searchInternal(nums, target, middle+1, end);
            }
        } else {
            if (nums[middle]<target && target<=nums[end]) {
                return searchInternal(nums, target, middle+1, end);

            } else {
                return searchInternal(nums, target, start, middle-1);

            }

        }
        
    }

}
