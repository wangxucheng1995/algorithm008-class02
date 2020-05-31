package com.leetcode.question121;

public class Solution {
    public int maxProfit(int[] prices) {
        int sell[] = new int[prices.length+1];
        for(int i=0;i<prices.length-1;i++){
            int maxP = maxPrice(prices,i);
            if(prices[i]>=maxP) sell[i] = 0;
            else sell[i] = maxP-prices[i];
        }
        int res = 0;
        for(int t:sell){
            res = Math.max(t,res);
        }
        return res;
    }

    private int maxPrice(int[] prices, int i) {
        int j= i+1;
        int max = 0;
        while(j<=prices.length-1){
            max = Math.max(prices[j],max);
            j++;
        }
        return max;
    }
}
