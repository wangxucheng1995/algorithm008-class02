package com.leetcode.question190;

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for(int i=0;i<32;i++){
            int temp = n>>i;
            int end = temp&1;
            int part = end<<(31-i);
            res = res|part;
        }
        return res;
    }
}