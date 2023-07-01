package _recall_75_questions;

import java.util.HashSet;
import java.util.Set;

public class _128_LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int longest = -1;
        Set<Integer> setValue = new HashSet<>();
        int i = 0;
        for(int num : nums) {
            setValue.add(num);
        }

        Set<Integer> visitedValue = new HashSet<Integer>();

        for(Integer value : setValue) {
            int tempLongest = 1;
            int greaterThanOne = value+1;
            int lessThanOne = value-1;
            if(!visitedValue.contains(value)) {
                while (setValue.contains(greaterThanOne)) {
                    tempLongest++;
                    visitedValue.add(greaterThanOne);
                    greaterThanOne++;
                }

                while (setValue.contains(lessThanOne)) {
                    tempLongest++;
                    visitedValue.add(lessThanOne);
                    lessThanOne--;
                }
                longest = longest > tempLongest ? longest : tempLongest;
            }

        }

        return longest;
    }
}