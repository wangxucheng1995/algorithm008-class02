package com.leetcode.question121;public class Solution2 {
    public int maxProfit(int[] prices) {
        if(prices.length<=1) return 0;
        int[] maxPrice = new int[prices.length];
        int res = 0;
        maxPrice[prices.length - 1] = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            maxPrice[i] = Math.max(prices[i], maxPrice[i + 1]); // [i...]股票能卖出的最大值
            res = Math.max(res, maxPrice[i] - prices[i]);
        }
        return res;
    }
}


