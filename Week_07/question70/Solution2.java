package com.leetcode.question70;

public class Solution2 {
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return climbHelp(n, memo);
    }

    private int climbHelp(int n, int[] memo) {
        if (n < 2) {
            memo[n] = 1;
            return memo[n];
        }
        if (n == 2) {
            memo[n] = 2;
            return memo[n];
        }

        if (memo[n] == 0) memo[n] = climbHelp(n - 1, memo) + climbHelp(n - 2, memo) + climbHelp(n - 3, memo);
        return memo[n];
    }
}
