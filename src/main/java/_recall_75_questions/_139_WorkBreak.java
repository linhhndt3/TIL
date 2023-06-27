package _recall_75_questions;

import java.util.List;

public class _139_WorkBreak {

    // TODO do not understand deeply -> limit time exceed
//    public boolean wordBreak(String s, List<String> wordDict) {
//        boolean[] dp = new boolean[s.length()+1];
//        dp[s.length()] = true;
//        for(int index = s.length()-1; index >= 0; index--) {
//            workBreakHelper(s,index,wordDict,dp);
//        }
//        return dp[0];
//    }
//
//    public boolean workBreakHelper(String s, int startIndex, List<String> wordDict, boolean[] dp) {
//        if(dp[startIndex]) {
//            return true;
//        }
//        if(startIndex >= s.length()) {
//            dp[startIndex] = true;
//            return true;
//        }
//        for(String word : wordDict) {
//            int lengthOfWord = word.length();
//            if(startIndex + lengthOfWord - 1 < s.length()) {
//                String subString = s.substring(startIndex, startIndex + lengthOfWord);
//                if(word.equals(subString)) {
//                    dp[startIndex] = workBreakHelper(s,startIndex + lengthOfWord,wordDict, dp);
//                    if(dp[startIndex]) {
//                        return true;
//                    }
//                }
//            }
//        }
//        return false;
//    }

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[s.length()] = true;
        for(int startIndex = s.length()-1; startIndex >= 0; startIndex--) {
            for(String word : wordDict ) {
                int lengthOfWord = word.length();
                if(startIndex + lengthOfWord - 1 < s.length()) {
                    String subString = s.substring(startIndex, startIndex + lengthOfWord);
                    if(word.equals(subString)) {
                        dp[startIndex] = dp[startIndex + lengthOfWord-1];
                        if(dp[startIndex]) {
                           break;
                        }
                    }
                }
            }
        }
        return dp[0];
    }

}