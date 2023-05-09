package _75_questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> rs = new ArrayList<>();
        threeSumHelper(nums,0,nums.length-1,rs);
        return rs;

    }

    public void threeSumHelper(int[] nums, int start, int end,List<List<Integer>> rs) {
        if(start+1>= end) {
            return;
        }
        int twoSum = nums[start] + nums[end];
        int addValue = 0 - twoSum;
        int l = start+1;
        int r = end-1;
        while(l <= r) {
            int middle = (l+r)/2;
            if(nums[middle] == addValue) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[start]);
                list.add(nums[end]);
                list.add(nums[middle]);
                rs.add(list);
                break;
            } else if(nums[middle] > addValue) {
                r = middle-1;
            } else {
                l = middle+1;
            }
        }

        int newStart = start+1;
        while(newStart < nums.length - 1 && nums[start] == nums[newStart] ) {
            newStart++;
        }
        threeSumHelper(nums,newStart,end,rs);
        int newEnd = end-1;
        while(newEnd >= 0 && nums[end] == nums[newEnd]) {
            newEnd--;
        }
        threeSumHelper(nums,start,newEnd,rs);

    }
}