package _recall_75_questions;

public class _424_LongestRepeatingCharacterReplacement {

    // TODO deeper about why it works
    public int characterReplacement(String s, int k) {
        int[] frequency = new int[26];
        int longestLength = 0;
        int start = 0;
        int max = 0;
        for(int end = 0; end < s.length(); end++) {
            max = max > ++frequency[s.charAt(end)-65] ? max : frequency[s.charAt(end)-65];
            if((end - start + 1) - max > k) {
                frequency[s.charAt(start)-65]--;
                start++;
            }
            longestLength = longestLength > (end-start+1) ? longestLength : (end-start+1);
        }
        return longestLength;
    }

    public static void main(String[] args) {
        System.out.println('A' - 65);
    }
}