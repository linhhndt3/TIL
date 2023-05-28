package _75_questions;

import java.util.*;

public class WordBreak_v1 {

    // TODO enhance runtime
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<Integer,String> map = new HashMap<>();
        return wordBreakHelper(s,0,wordDict,map);
    }

    private boolean wordBreakHelper(String s, int start, List<String> wordDict,Map<Integer,String> map) {
        if(start >= s.length()) {
            return true;
        }
        boolean couldBeBreak = false;
        for(String word : wordDict) {
            if(isContainWord(s,start,word,map)) {
                couldBeBreak = couldBeBreak || wordBreakHelper(s, start + word.length(),wordDict,map);
            }
            if(couldBeBreak) {
                return true;
            }
        }
        return couldBeBreak;
    }

    private boolean isContainWord(String s,int start, String word,Map<Integer,String> map) {
        for(Character c : word.toCharArray() ) {
            if(start >= s.length()) {
                return false;
            }
            if(c != s.charAt(start)) {
                return false;
            } else {
                start++;
            }
        }
        map.put(start,word);
        return true;
    }
}