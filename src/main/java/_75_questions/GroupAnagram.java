package _75_questions;

import java.util.*;

public class GroupAnagram {

    // TODO enhance runtime
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        List<List<String>> rs = new ArrayList<>();
        Map<String,Map<Character,Integer>> dp = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            Map<Character,Integer> currentMap = generateMap(strs[i]);
            dp.put(strs[i],currentMap);
            boolean isFound = false;
            for(List<String> e : rs) {
                if(e != null && e.size() != 0) {
                    String s = e.get(0);
                    Map<Character,Integer> existingMap = dp.get(s);
                    if(isSameMap(existingMap,currentMap)) {
                        e.add(strs[i]);
                        isFound = true;
                        break;
                    }
                }
            }
            if(!isFound) {
                rs.add(new ArrayList<>(Collections.singleton(strs[i])));
            }
        }

        return rs;
    }

    Map<Character,Integer> generateMap(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(Character c : s.toCharArray()) {
            int count = map.getOrDefault(c,0);
            map.put(c,count+1);
        }

        return map;
    }

    boolean isSameMap(Map<Character,Integer> map1, Map<Character,Integer> map2) {
        if(map1.size() != map2.size()) {
            return false;
        }
        for(Map.Entry<Character,Integer> entry : map1.entrySet()) {
            Character keyM1 = entry.getKey();
            Integer valueM1 = entry.getValue();
            if(map2.get(keyM1) != valueM1) {
                return false;
            }
        }
        return true;
    }
}