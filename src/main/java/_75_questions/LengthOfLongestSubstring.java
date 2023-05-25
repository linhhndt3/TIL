package _75_questions;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 0) {
            return s.length();
        }
        int maxLength = 1;
        int start = 0;
        Map<Character,Integer> map = new HashMap<>();
        map.put(s.charAt(0),0);
        for(int i = 1; i < s.length(); i++) {
            char currentCharacter = s.charAt(i);
            int lastIndexOfCurrentCharacter = map.getOrDefault(currentCharacter,-1);
            if(lastIndexOfCurrentCharacter < start) {
                maxLength = maxLength > (i - start) + 1 ? maxLength : (i - start) + 1;
                map.put(currentCharacter,i);
            } else {
                start = lastIndexOfCurrentCharacter+1;
                map.put(currentCharacter,i);
            }

        }
        return maxLength;
    }
}