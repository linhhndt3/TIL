package binarysearch;

public class _162_FindPeakElement {
    public int findPeakElement(int[] nums) {
        int peakIndex = -1;
        int s = 0;
        int end = nums.length - 1;
        // TODO why s = mid + 1 or end = mid - 1
        while(s <= end) {
            int mid = (s + end) / 2;
            if( ((mid - 1 < 0) || nums[mid] > nums[mid-1] ) && ((mid + 1) > end || nums[mid] > nums[mid+1])) {
                return mid;
            }
            if(nums[mid] < nums[mid+1]) {
                s = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return peakIndex;
    }
}
