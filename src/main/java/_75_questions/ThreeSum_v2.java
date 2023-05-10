package _75_questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_v2 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> rs = new ArrayList<>();
        // TODO enhancement for running time
        for(int i = 0; i <= nums.length-3; i++) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            } else {
                for(int j = nums.length-1; j > i+1; j--) {
                    if(j < nums.length-1 && nums[j] == nums[j+1]) {
                        continue;
                    }
                    int twoSum = nums[i] + nums[j];
                    int _3_index = binarysearch(nums,i+1,j-1,0-twoSum);
                    if(_3_index != -1) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[_3_index]);
                        rs.add(list);
                    }
                }
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        new ThreeSum_v2().binarysearch(new int[]{-2,0,1,1,2},1,2,1);
    }
    int binarysearch(int[] nums, int start, int end, int target) {
        int l = start;
        int r = end;
        while(l <= r) {
            int middle = (l+r)/2;
            if(nums[middle] == target) {
                return middle;
            } else if(nums[middle] > target) {
                r = middle-1;
            } else {
                l = middle+1;
            }
        }
        return -1;
    }

}