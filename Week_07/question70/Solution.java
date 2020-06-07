package com.leetcode.question70;
public class Solution {
    public int climbStairs(int n) {
        int[] nums = new int[n+1];
        return climbStairs(n,nums);
    }
    private int  climbStairs(int n, int[]nums){
        if(n<=1){
            return 1;
        }
        if(nums[n]!=0){
            return nums[n];
        }
        nums[n] = climbStairs(n-1,nums)+climbStairs(n-2,nums);
        return nums[n];
    }
}

