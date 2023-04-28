package _75_questions;

public class ClimbingStairs_v1 {
    public static void main(String[] args) {

    }

    public int climbStairs(int n) {
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        int[] rs = new int[n+1];
        rs[1] = 1;
        rs[2] = 2;

        // TODO note: divide and conquer -> sub problem
        for(int i = 3; i <= n; i++) {
            rs[i] = rs[i-1] + rs[i-2];
        }
        return rs[n];
    }
}