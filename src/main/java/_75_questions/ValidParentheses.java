package _75_questions;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for(char c: s.toCharArray()){
            if(isOpenBracket(c)) {
                stack.add(c);
            } else {
                if(!stack.isEmpty()) {
                    char lastCharacter = stack.pop();
                    if(!isCorrectClose(lastCharacter,c)) {
                        return false;
                    }
                }
                return false;
            }
        }
        return stack.isEmpty();
    }

    private boolean isOpenBracket(char c) {
        if(c=='(' || c=='{' || c=='[') {
            return true;
        }
        return false;
    }

    private boolean isCorrectClose(char lastCharacter, char currentCharacter) {
        if((currentCharacter == ')' && lastCharacter == '(')
                || (currentCharacter == '}' && lastCharacter == '{')
                || (currentCharacter == ']' && lastCharacter == '[')) {
            return true;
        }
        return false;
    }
}