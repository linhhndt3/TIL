package _75_questions;

import java.util.*;

public class _494_TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        Map<Key,Integer> dp = new HashMap<>();
        helper(nums,target,0,dp);
        return dp.get(new Key(0,target));
    }

    private void helper(int[] nums, int target, int pointer, Map<Key,Integer> dp) {
        Key key = new Key(pointer,target);
        if(dp.containsKey(key)) {
            return;
        }

        if(pointer == nums.length-1) {
            if(nums[pointer] == target || nums[pointer] == -1 * target) {
                if(target==0) {
                    dp.put(key,2);
                } else {
                    dp.put(key,1);
                }
            } else {
                dp.put(key,0);
            }
            return;
        }

        helper(nums,target-nums[pointer],pointer+1,dp);
        helper(nums,target+nums[pointer],pointer+1,dp);
        int first = dp.get(new Key(pointer+1,target-nums[pointer]));
        int second = dp.get(new Key(pointer+1,target+nums[pointer]));
        dp.put(key, (first+second));
    }

    public static void main(String[] args) {
        System.out.println(new _494_TargetSum().findTargetSumWays(new int[]{1,1,1,1,1}, 3));
//        System.out.println(new _494_TargetSum().findTargetSumWays(new int[]{1,1}, 3));
    }
}

class Key {
    int index;
    int target;

    public Key(int index, int target) {
        this.index = index;
        this.target = target;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Key)) return false;
        Key key = (Key) o;
        return index == key.index && target == key.target;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, target);
    }
}