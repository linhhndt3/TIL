package _recall_75_questions;

public class _Math_pow {
    private int calculate(int n, int power) {
        if(power == 1) {
            return n;
        }
        int tempRs = calculate(n, power/2);
        tempRs *= tempRs;
        if(power%2 != 0) {
            tempRs = tempRs*n;
        }

        return tempRs;
    }

    public static void main(String[] args) {
        System.out.println(new _Math_pow().calculate(2,9));
    }
}