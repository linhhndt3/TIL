package twopointer;

public class _844_BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        String s1 = generate(s);
        String t1 = generate(t);
        return s1.equals(t1);
    }

    private String generate(String s) {
        StringBuilder convertedS = new StringBuilder();
        for(int i = 0; i < s.length();i++) {
            char currentChar = s.charAt(i);
            if(currentChar != '#') {
                convertedS.append(currentChar);
            } else {
                if(convertedS.length() > 0) {
                    convertedS.deleteCharAt(convertedS.length() - 1);
                }
            }
        }
        return convertedS.toString();
    }
}


