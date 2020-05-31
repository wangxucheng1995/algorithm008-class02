package com.leetcode.question45;

public class Solution {
    public int jump(int[] nums) {
        int count = 0;
        int end = nums.length-1;
        while(end>0){
            for(int i=0;i<end;i++){
                if(nums[i]+i>=end){
                    end = i;
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
