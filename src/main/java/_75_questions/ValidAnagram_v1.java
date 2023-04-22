package _75_questions;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram_v1 {
    public boolean isAnagram(String s, String t) {

        // TODO improve performance by using primitive array
        if(s.length() != t.length()) {
            return false;
        }
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();
        for(int index = 0; index < s.length(); index++) {
            char c1 = s.charAt(index);
            char c2 = t.charAt(index);
            map1.put(c1, map1.get(c1) == null ? 1 : map1.get(c1) + 1);
            map2.put(c2, map2.get(c2) == null ? 1 : map2.get(c2) + 1);
        }
        for(Map.Entry<Character,Integer> entry : map1.entrySet()) {
            Character c1 = entry.getKey();
            Integer numberOfC1 = entry.getValue();
            if(map2.get(c1) == null || !map2.get(c1).equals(numberOfC1)) {
                return false;
            }
        }
        return true;
    }
}