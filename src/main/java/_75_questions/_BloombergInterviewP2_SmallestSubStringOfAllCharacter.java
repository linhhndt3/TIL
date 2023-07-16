package _75_questions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _BloombergInterviewP2_SmallestSubStringOfAllCharacter {

    static String getShortestUniqueSubstring(char[] arr, String str) {
        int startIndexRs = -1;
        int endIndexRs = -1;
        int min = Integer.MAX_VALUE;
        Set<Character> set = new HashSet<>();
        for(char c : arr) {
            set.add(c);
        }
        Map<Character,Integer> map = new HashMap<>();
        int numberOfUniqueArr = arr.length;
        int numberOfUniqueStr = 0;

        int start = 0;
        for(int end = 0; end < str.length(); end++) {
            Character current = str.charAt(end);
            Integer countOfCurrent = map.getOrDefault(current,0);
            map.put(current,countOfCurrent+1);
            if(set.contains(current) && map.getOrDefault(current,0) == 1) {
                numberOfUniqueStr++;
            }

            startIndexRs = start;
            endIndexRs = end;
            while(numberOfUniqueStr == numberOfUniqueArr) {
                if(min > (end-start+1)) {
                    startIndexRs = start;
                    endIndexRs = end;
                    min = end-start+1;
                }

                Character characterAtStart = str.charAt(start);
                Integer countOfCharacterAtStart = map.get(characterAtStart);
                map.put(str.charAt(start),countOfCharacterAtStart-1);
                if(set.contains(current) && map.get(characterAtStart) == 0) {
                    numberOfUniqueStr--;
                }
                start++;
            }

        }
        if(startIndexRs == -1) {
            return "";
        }

        return str.substring(startIndexRs,endIndexRs+1);
    }

    public static void main(String[] args) {
        System.out.println(getShortestUniqueSubstring(new char[]{'x','y','z'},"xyyzyzyx"));
    }
}