package twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rss = new ArrayList<>();
        Arrays.sort(nums);
        removeDuplicate(nums);
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                int index = findIndex(0 - (nums[i] + nums[j]),j+1,nums.length - 1,nums);
                if(index != -1) {
                    List<Integer> rs = new ArrayList<>();
                    rs.add(nums[i]);
                    rs.add(nums[j]);
                    rs.add(nums[index]);
                    rss.add(rs);
                }
            }
        }
        return rss;
    }

    private int[] removeDuplicate(int[] nums) {
        // TODO impl
        return null;
    }

    private int findIndex(int target, int start, int end, int[] nums) {
        int index = -1;
        while (start <= end) {
            int mid = (start+end) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return index;
    }
}
