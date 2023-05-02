package _75_questions;

public class UniquePath {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int r = 0; r < m; r++) {
            dp[r][n] = 1;
        }
        for(int c = 0; c < n; c++) {
            dp[m][c] = 1;
        }
        for(int r = m-2; r >= 0; r--) {
            for(int c = n-2; c >= 0; c--){
                dp[r][c] = dp[r+1][c] + dp[r][c+1];
            }
        }
        return dp[0][0];
    }
}