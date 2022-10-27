package slidingWindow;

public class MinSizeSubArraySum {
    public static int findMinSubArray(int S, int[] arr) {
        // TODO: Write your code here
        int minSub = Integer.MAX_VALUE;
        int sum = 0;
        for(int start = 0, end = 0; end < arr.length;end++) {
            sum+=arr[end];
            while (sum >= S) {
                minSub = end - start > minSub ? minSub : end - start;
                start++;
                sum-=arr[start];
            }
        }
        return minSub;
    }
}
