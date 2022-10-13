package dp;

public class SubsetSum {
    public boolean canPartition(int[] num, int sum) {
        // TODO: Write your code here
        boolean[][] rs = new boolean[num.length][sum+1];
        for(int j = 0; j <= sum; j++) {
            rs[0][j] = num[0] == j ? true : false;
        }
        for(int i = 1; i < num.length; i++) {
            int currentNum = num[i];
            for(int j = 0; j <= sum; j++) {
                if(j-currentNum<0) {
                    rs[i][j] = rs[i-1][j];
                } else {
                    rs[i][j] = currentNum == j || rs[i-1][j-currentNum] || rs[i-1][j];
                }

            }
        }
        System.out.println(rs);
        return rs[num.length-1][sum];
    }

    public static void main(String[] args) {
        SubsetSum ss = new SubsetSum();
        int[] num = { 1, 2, 3, 7 };
        System.out.println(ss.canPartition(num, 6));
        num = new int[] { 1, 2, 7, 1, 5 };
        System.out.println(ss.canPartition(num, 10));
        num = new int[] { 1, 3, 4, 8 };
        System.out.println(ss.canPartition(num, 6));
    }


}
