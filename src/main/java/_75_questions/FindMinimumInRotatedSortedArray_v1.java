package _75_questions;

public class FindMinimumInRotatedSortedArray_v1 {
    public int findMin(int[] nums) {
        if(nums[0] < nums[nums.length-1]) {
            return nums[0];
        }
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            if(l==r) {
                return nums[l];
            }
            int m = (l + r) / 2;
            if(nums[m] > nums[l]) {
                if(nums[m] > nums[r]) {
                    l = m+1;
                } else {
                    r = m;
                }

            } else if(nums[m] < nums[l]) {
                r = m;
            } else {
                return nums[m] < nums[r] ? nums[m] : nums[r];
            }
        }
        return -1;
    }
}