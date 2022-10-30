package binarysearch;

public class _34_FindFirstAndLastPosition {
    public int[] searchRange(int[] nums, int target) {
        int firstFoundedIndex = -1;
        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            int mid = (start+end) / 2;
            if(nums[mid] == target) {
                firstFoundedIndex = mid;
                break;
            } else if(nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if(firstFoundedIndex == -1) {
            return new int[] {-1,-1};
        }

        int first = findFromTheLeft(nums,target,start,firstFoundedIndex);
        int second = findFromTheRight(nums,target, firstFoundedIndex,end);
        return new int[]{first,second};
    }
    public int findFromTheLeft(int[] nums, int target, int start, int end) {
        while(start <= end) {
            if(start == end) {
                return start;
            }
            int mid = (start+end) / 2;
            if(nums[mid] < target) {
                start = mid + 1;
            } else  {
                end = mid;
            }
        }
        return end;
    }

    public int findFromTheRight(int[] nums, int target, int start, int end) {
        while(start <= end) {
            if(start == end) {
                return start;
            }
            int mid = (start+end) / 2 + 1;
            if(nums[mid] > target) {
                end = mid - 1;
            } else  {
                start = mid;
            }
        }
        return start;
    }
}
