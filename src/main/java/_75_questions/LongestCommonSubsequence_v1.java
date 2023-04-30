package _75_questions;

public class LongestCommonSubsequence_v1 {
    public static void main(String[] args) {
        new LongestCommonSubsequence_v1().longestCommonSubsequence("abcde", "ace");
    }
    // TODO how to divide the problem to subproblem
    // TODO how to use the maxtrix to indices the subproblem
    // TODO learn vocabulary
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text2.length();
        int n = text1.length();
        int[][] dp = new int[m+1][n+1];
        for(int c = 0; c <= n; c++) {
            dp[m][c] = 0;
        }
        for(int r = 0; r <= m; r++) {
            dp[r][n] = 0;
        }
        for(int r = m-1; r >= 0; r--) {
            for(int c = n-1; c >= 0; c--) {
                if(text2.charAt(r) == text1.charAt(c)) {
                    dp[r][c] = 1 + dp[r+1][c+1];
                } else {
                    dp[r][c] = Math.max(dp[r][c+1],dp[r+1][c]);
                }
            }
        }
        return dp[0][0];
    }
}