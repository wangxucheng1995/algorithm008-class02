package com.leetcode.question322;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount<=0||coins==null||coins.length==0)return -1;

        int[] memo = new int[amount+1];
        memo[0] = 0;
        for(int i=1;i<=amount;i++){
            int tempMin = amount+1;
            for(int money:coins){
                if(money<=i){
                    if(memo[i-money]==-1) continue;
                    tempMin = Math.min(tempMin,memo[i-money]);
                }
                if(tempMin!=amount+1){
                    memo[i] = tempMin+1;
                }else {
                    memo[i] = -1;
                }
            }
        }
        return memo[amount];
    }
}
