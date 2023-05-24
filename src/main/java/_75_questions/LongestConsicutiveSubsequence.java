package _75_questions;

import java.util.HashMap;
import java.util.Map;

public class LongestConsicutiveSubsequence {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int longest = -1;
        Map<Integer,Integer> mapValueAndIndex = new HashMap<>();
        int i = 0;
        for(int num : nums) {
            mapValueAndIndex.put(num,i);
            i++;
        }
        for(Map.Entry<Integer,Integer> entry : mapValueAndIndex.entrySet()) {
            int value = entry.getKey();
            int index = entry.getValue();
            int greaterThanOne = value+1;
            int lessThanOne = value-1;
            if(index != -1) {
                int tempLongest = 1;
                while (mapValueAndIndex.getOrDefault(greaterThanOne,-1)  >= 0) {
                    tempLongest++;
                    mapValueAndIndex.put(greaterThanOne,-1);
                    greaterThanOne++;

                }

                while (mapValueAndIndex.getOrDefault(lessThanOne,-1) >= 0) {
                    tempLongest++;
                    mapValueAndIndex.put(lessThanOne,-1);
                    lessThanOne--;
                }
                longest = longest > tempLongest ? longest : tempLongest;
            }
        }

        return longest;
    }
}