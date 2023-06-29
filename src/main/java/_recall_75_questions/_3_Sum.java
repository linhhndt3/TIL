package _recall_75_questions;

import java.util.*;

public class _3_Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rs = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            int tempSum = 0 - nums[i];
            Set<Integer> set = new HashSet<>();
            while (l < r) {
                if(nums[l] + nums[r] == tempSum) {
                    if(!set.contains(nums[l])) {
                        List<Integer> tempRs = new ArrayList<>();
                        tempRs.add(nums[i]);
                        tempRs.add(nums[l]);
                        tempRs.add(nums[r]);
                        set.add(nums[l]);
                        set.add(nums[r]);
                        rs.add(tempRs);
                        l++;
                        r--;
                    }
                } else if(nums[l] + nums[r] > tempSum) {
                    r--;
                } else {
                    l++;
                }
            }
        }

        return rs;
    }

    public static void main(String[] args) {
        new _3_Sum().threeSum(new int[]{-1,0,1,2,-1,-4});
    }
}