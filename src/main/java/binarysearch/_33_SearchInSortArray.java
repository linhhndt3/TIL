package binarysearch;

public class _33_SearchInSortArray {
    public int search(int[] nums, int target) {
        return searchHelper(nums, target, 0, nums.length - 1);
    }

    public int searchHelper(int[] nums, int target, int start, int end) {
        int foundedIndex = -1;

        while(start <= end) {

            if(start == end) {
                return nums[start] == target ? start : -1;
            }

            int midle = (start + end) / 2;

            if(nums[midle] == target) {
                return midle;
            }

            if(nums[start] == target) {
                return start;
            }

            if(nums[midle] >= nums[start]) {
                if(target < nums[start] || target > nums[midle]) {
                    start = midle + 1;
                    continue;
                } else {
                    end = midle;
                    continue;
                }

            } else {
                if(target > nums[start] || target < nums[midle]) {
                    end = midle - 1;
                    continue;
                } else {
                    start = midle + 1;
                    continue;
                }
            }
        }
        return foundedIndex;
    }
}
