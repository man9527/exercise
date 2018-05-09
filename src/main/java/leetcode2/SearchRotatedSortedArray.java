package leetcode2;

public class SearchRotatedSortedArray {

    public static void main(String[] args) {
        int[] a = {5,1,3};

        System.out.println(new SearchRotatedSortedArray().search(a, 3));
    }
    public int search(int[] nums, int target) {

        return searchRec(nums, 0, nums.length-1, target);
        
    }

    public int searchRec(int[] nums, int begin, int end, int target) {

        if (begin>end) {
            return -1;
        }

        int mid = (begin+end)/2;

        if (nums[mid]==target) {
            return mid;
        }

        if (nums[mid]>target && target>=nums[begin]) {
            return searchRec(nums, begin, mid-1, target);
        } else if (nums[mid]>target && target<nums[begin]) {
            return searchRec(nums, mid+1, end, target);
        } else if (nums[mid]<target && nums[mid]>=nums[begin]) {
            return searchRec(nums, mid+1, end, target);
        } else if (nums[mid]<target && nums[mid]<nums[begin] && target>nums[end]) {
            return searchRec(nums, begin, mid-1, target);
        } else if (nums[mid]<target && target<nums[begin] && target<=nums[end]) {
        return searchRec(nums, mid+1, end, target);
    }
        else {
            return -1;
        }

    }
}
