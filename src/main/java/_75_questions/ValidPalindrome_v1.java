package _75_questions;

public class ValidPalindrome_v1 {
    public static void main(String[] args) {
        new ValidPalindrome_v1().isPalindrome("race a car");
    }
    public boolean isPalindrome(String s) {
        StringBuilder sAfterRemoved = new StringBuilder();
        for(char c : s.toCharArray()) {
            if((Character.isDigit(c) || Character.isLetter(c)) && c != ' ') {
                sAfterRemoved.append(c);
            }
        }
        s = sAfterRemoved.toString().toLowerCase();
        if(s.length()==0){
            return true;
        }
        int i=0;
        int j=s.length()-1;
        while(i<=j){
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}