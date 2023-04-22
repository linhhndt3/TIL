package _75_questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum_v1 {
    public int[] twoSum(int[] nums, int target) {
        int[] rs = new int[2];
        Map<Integer,Integer> mapOfTwoOperator = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            int currentVal = nums[i];
            int needToAdd = target-currentVal;
            if(mapOfTwoOperator.get(needToAdd) != null) {
                return new int[]{i,mapOfTwoOperator.get(needToAdd)};
            } else {
                mapOfTwoOperator.put(currentVal,i);
            }
        }

        return rs;
    }
}