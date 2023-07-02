package _75_questions;

import java.util.*;

public class _239_SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int start = 0;
        int[] maxWindows = new int[nums.length - (k-1)];
        int count = 0;
        int max = Integer.MIN_VALUE;
        SortedSet<Integer> maxHeap = new TreeSet<>((a, b) -> {return b-a;});
        Map<Integer,Integer> map = new HashMap<>();
        for(int end = 0; end < nums.length; end++) {
            int currentNumber = nums[end];
            maxHeap.add(currentNumber);
            int frequent = map.getOrDefault(currentNumber, 0);
            map.put(currentNumber,frequent+1);

            if(end - start + 1 >= k) {
                max = maxHeap.first();
                maxWindows[count] = max;
                count++;
                map.put(nums[start], map.get(nums[start]) - 1);
                if(map.get(nums[start]) == 0) {
                    maxHeap.remove(nums[start]);
                }

                start++;
            }
        }
        return maxWindows;
    }

    public static void main(String[] args) {

    }
}