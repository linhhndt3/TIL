package _75_questions;

public class PalindromicSubstrings {
    public static void main(String[] args) {
        new PalindromicSubstrings().longestPalindrome("babad");
    }

    public int countSubstrings(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            count = count + 1 + countSubstringsHelper(s,i-1,i+1) + countSubstringsHelper(s,i,i+1);
        }
        return count;
    }

    private int countSubstringsHelper(String s, int l, int r) {
        if(l < 0 || r > s.length() - 1) {
            return 0;
        }
        if(s.charAt(l) == s.charAt(r)) {
            return 1 + countSubstringsHelper(s,l-1,r+1);
        } else {
            return 0;
        }
    }

    public String longestPalindrome(String s) {
        int maxOddLength = 0;
        int maxEvenLength = 0;
        int minOddIndex = 0; int maxOddIndex = 0;
        int minEvenIndex = 0; int maxEvenIndex = 0;
        int l = 0; int r = 0;

        //TODO merge while block
        for(int i = 0; i < s.length(); i++) {
            l = i; r = i;
            while(l >=0 && r <= s.length() - 1 && s.charAt(l) == s.charAt(r)) {
                if(r-l+1 > maxOddLength) {
                    minOddIndex = l;
                    maxOddIndex = r;
                    maxOddLength = r-l+1;
                }
                l--;
                r++;
            }

            l = i; r = i+1;
            while(l >=0 && r <= s.length() - 1 && s.charAt(l) == s.charAt(r)) {
                if(r-l+1 > maxEvenLength) {
                    minEvenIndex = l;
                    maxEvenIndex = r;
                    maxEvenLength = r-l+1;
                }
                l--;
                r++;
            }

        }
        if(maxOddLength >= maxEvenLength) {
            return s.substring(minOddIndex, maxOddIndex+1);
        } else {
            return s.substring(minEvenIndex,maxEvenIndex+1);
        }
    }
}