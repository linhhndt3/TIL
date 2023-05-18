package _75_questions;

import java.util.Stack;

public class EvaluateReversePolishNotion {
    public int evalRPN(String[] tokens) {
        Stack<Integer> worker = new Stack<>();
        for (String token : tokens) {
            if(!isOperator(token)) {
                worker.push(convertStringToInt(token));
            } else {
                int number2 = worker.pop();
                int number1 = worker.pop();
                worker.push(calculate(number1,number2,token));
            }
        }

        return worker.pop();

    }

    boolean isOperator(String token) {
        if(token.equals("/") || token.equals("*") || token.equals("+") || token.equals("-")) {
            return true;
        }
        return false;
    }

    int calculate(Integer number1, Integer number2, String operator) {
        if(operator.equals("/")) {
            return number1 / number2;
        }
        if(operator.equals("*")) {
            return number1 * number2;
        }
        if(operator.equals("-")) {
            return number1 - number2;
        }
        if(operator.equals("+")) {
            return number1 + number2;
        }
        return -1;
    }

    int convertStringToInt(String number) {
        return Integer.parseInt(number);
    }
}