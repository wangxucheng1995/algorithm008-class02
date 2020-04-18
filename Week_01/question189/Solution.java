package com.leetcode.question189;

public class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int length = nums.length;
        for(int count =0;count<k;count++){
            int end = length-1;//最后一个数所在的游标
            int end_num = nums[end];//保存最后一个数值
            for(;end>0;end--){
                nums[end] = nums[end-1];
            }
            nums[0]=end_num;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.rotate(new int[]{1,2,3,4,5,6,7
        },3);
    }
}
