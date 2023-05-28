package _75_questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak_v2 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[s.length()] = true;
        for(int i = s.length() - 1; i >= 0; i--) {
            for(String word : wordDict) {
                if(i + word.length() <= s.length() && s.substring(i,i+word.length()).startsWith(word)) {
                    dp[i] = dp[i+word.length()];
                }
                if(dp[i]) {
                    break;
                }
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("cats");
        list.add("dog");
        list.add("sand");
        list.add("and");
        list.add("cat");
        new WordBreak_v2().wordBreak("catsandog",new ArrayList<>(list));
    }
}