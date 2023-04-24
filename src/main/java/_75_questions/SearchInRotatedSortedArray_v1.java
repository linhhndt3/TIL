package _75_questions;

public class SearchInRotatedSortedArray_v1 {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if(nums[m] == target) {
                return m;
            }
            if(nums[m] > nums[l]) {
                if(target >= nums[m]) {
                    l = m;
                } else {
                    if(target >= nums[l]) {
                        r = m;
                    } else {
                        l = m+1;
                    }
                }
            } else if(nums[m] < nums[l]) {
                if(target <= nums[m]) {
                    r = m;
                } else {
                    if(target <= nums[r]) {
                        l = m + 1;
                    } else {
                        r = m-1;
                    }
                }
            } else {
                if(nums[l] == target) {
                    return l;
                }
                if(nums[r] == target) {
                    return r;
                }
                return -1;
            }
        }
        return -1;
    }
}