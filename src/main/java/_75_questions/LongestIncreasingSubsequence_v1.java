package _75_questions;

public class LongestIncreasingSubsequence_v1 {
    public static void main(String[] args) {
        new LongestIncreasingSubsequence_v1().lengthOfLIS(new int[] {1,4,2,3});
        new LongestIncreasingSubsequence_v1().lengthOfLIS(new int[] {10,9,2,5,3,7,101,18});
    }
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 1) {
            return 1;
        }
        int[] lengthOfLISstartAtIndex = new int[nums.length];
        lengthOfLISstartAtIndex[nums.length - 1] = 1;
        int max = -1;
        for(int i = nums.length - 2; i >= 0; i--) {
            int tempMax = -1;
            for(int j = i + 1; j < nums.length; j++) {
                tempMax = nums[i] < nums[j] ? 1 + lengthOfLISstartAtIndex[j] : 1;
                lengthOfLISstartAtIndex[i] = lengthOfLISstartAtIndex[i] < tempMax ? tempMax : lengthOfLISstartAtIndex[i];
            }
            max = max < lengthOfLISstartAtIndex[i] ? lengthOfLISstartAtIndex[i] : max;
        }
        return max;
    }
}