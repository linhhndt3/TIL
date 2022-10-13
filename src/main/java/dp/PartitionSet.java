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

    public int canMinPartition(int[] nums) {
        int sum = findSumOf(nums);
        int min = Integer.MAX_VALUE;
        boolean[][] rs = new boolean[nums.length][sum];
        for(int j = 0; j <= sum-1; j++) {
            rs[0][j] = nums[0] == j ? true : false;
        }
        for(int i = 1; i < nums.length; i++) {
            int currentNum = nums[i];
            for(int j = 0; j <= sum-1; j++) {
                if(j-currentNum<0) {
                    rs[i][j] = rs[i-1][j];
                } else {
                    rs[i][j] = currentNum == j || rs[i-1][j-currentNum] || rs[i-1][j];
                }
                if(rs[i][j]) {
                    min = min < Math.abs(sum -2*j) ? min : Math.abs(sum -2*j);
                }
            }
        }
        System.out.println(rs);
        return min;
    }

    private int findSumOf(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum+=num;
        }
        return sum;
    }

    public static void main(String[] args) {

//        new PartitionSet().canPartition(new int[]{2,2,1,1});
        PartitionSet ps = new PartitionSet();
        int[] num = {1, 2, 3, 9};
        System.out.println(ps.canMinPartition(num));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ps.canMinPartition(num));
        num = new int[]{1, 3, 100, 4};
        System.out.println(ps.canMinPartition(num));
    }

}
