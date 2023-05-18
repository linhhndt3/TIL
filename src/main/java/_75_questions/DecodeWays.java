package _75_questions;

public class DecodeWays {
    public int numDecodings(String s) {
        if(s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[s.length()+1];
        dp[s.length()] = 1;
        dp[s.length() - 1] = s.charAt(s.length() - 1) == '0' ? 0 : 1;
        int index = s.length() - 2;
        while(index >= 0) {
            Character currentCharater = s.charAt(index);
            if(currentCharater == '0') {
                dp[index] = 0;
            } else {
                if(s.charAt(index) == '1' ||
                        (s.charAt(index) == '2' && s.charAt(index + 1) < '7')) {
                    dp[index] = dp[index+1] + dp[index+2];
                } else {
                    dp[index] = dp[index+1];
                }
            }
            index--;
        }

        return dp[0];
    }

    public static void main(String[] args) {
        new DecodeWays().numDecodings("226");
    }
}