package _recall_75_questions;

public class _128_LongestConsicutiveSequence {
    public int longestConsecutive(int[] nums) {
        int size = 10*10*10*10*10*10*10*10 + 1;
        int[] countPositive = new int[size];
        int[] countNegative = new int[size];
        for(int index = 0; index < nums.length; index++) {
            if(nums[index] >= 0) {
                countPositive[nums[index]]++;
            } else {
                countNegative[nums[index] * -1]++;
            }

        }
        int max = -1;
        int countPartition = 0;
        int start = 0;
        int end = 0;
        if(countPositive[0] > 0) {
            int index = 0;
            while (countPositive[index] > 0) {
                index++;
            }
            start = index;
            index = 1;
            while (countNegative[index] > 0) {
                index++;
            }
            end = index;
            max = Math.max(start + (end - 1),max);
        }

        for(int i = start; i < countPositive.length; i++) {
            if (countPositive[i] > 0) {
                countPartition++;
                continue;
            }
            if(countPositive[i] == 0) {
                max = Math.max(countPartition,max);
                countPartition = 0;
            }
        }
        countPartition = 0;
        for(int i = end; i < countNegative.length; i++) {
            if (countNegative[i] > 0) {
                countPartition++;
                continue;
            }
            if(countNegative[i] == 0) {
                max = Math.max(countPartition,max);
                countPartition = 0;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        new _128_LongestConsicutiveSequence().longestConsecutive(new int[] {1,2,3});
    }
}