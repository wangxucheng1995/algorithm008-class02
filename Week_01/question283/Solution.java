package com.leetcode.question283;

public class Solution {
    public void moveZeroes(int[] nums) {
        int cur = 0;
        int end = nums.length-1;

        //找到最後一個非0元素所在的索引
        while(end>0){
            if(nums[end]!=0){
                break;
            }
            end--;
        }

        while(cur<end){
            if(nums[cur]!=0){
                cur++;
            }else {
                for(int j=cur;j<end;j++){
                    nums[j] = nums[j+1];
                }
                nums[end]=0;
                end--;
            }
        }
    }
}
