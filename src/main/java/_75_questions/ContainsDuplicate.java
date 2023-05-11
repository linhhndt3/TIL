package _75_questions;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        int[] bucket = new int[(int)Math.pow(10,9)];

        // TODO do not use for(...) by this style(use index i) when i is not necessary
        for(int i = 0; i < nums.length; i++) {
            if(bucket[nums[i]] == 1) {
                return true;
            } else {
                bucket[nums[i]] = 1;
            }
        }
        return false;
    }
}