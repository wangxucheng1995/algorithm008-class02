package com.leetcode.question49;


public class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int a = 0;
        int b = 0;
        int c = 0;
        for(int i=1;i<n;i++){
            int da = dp[a]*2;
            int db = dp[b]*3;
            int dc = dp[c]*5;
            dp[i] = Math.min(Math.min(da,db),dc);
            if(dp[i]==da) a++;
            if(dp[i]==db) b++;
            if(dp[i]==dc) c++;
        }
        return dp[n-1];
    }
}
