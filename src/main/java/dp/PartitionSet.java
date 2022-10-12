package dp;

public class PartitionSet {
    public boolean canPartition(int[] nums) {
        int sum = findSumOf(nums);
        if(sum/2 == 1) {
            return false;
        }
        boolean[][] rs = new boolean[nums.length][sum/2+1];
        for(int j = 0; j <= sum/2; j++) {
            rs[0][j] = nums[0] == j ? true : false;
        }
        for(int i = 1; i < nums.length; i++) {
            int currentNum = nums[i];
            for(int j = 0; j <= sum/2; j++) {
                if(j-currentNum<0) {
                    rs[i][j] = rs[i-1][j];
                } else {
                    rs[i][j] = currentNum == j || rs[i-1][j-currentNum] || rs[i-1][j];
                }

            }
        }
        System.out.println(rs);
        return rs[nums.length-1][sum/2];
    }

    private int findSumOf(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum+=num;
        }
        return sum;
    }

    public static void main(String[] args) {
        new PartitionSet().canPartition(new int[]{2,2,1,1});
    }
}
