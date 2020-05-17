package com.leetcode.question55;

public class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null) return false;

        int endReachable = nums.length - 1;
        for (int i = endReachable; i >= 0; i--) {
            if (nums[i] + i >= endReachable) {
                endReachable = i;
            }
        }
        return endReachable == 0;
    }
}
