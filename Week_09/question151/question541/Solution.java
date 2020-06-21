package com.leetcode.question541;


import java.util.Arrays;

class Solution {
    public String reverseStr(String s, int k) {
        char[] string = s.toCharArray();
        for(int i=0;i<string.length;i=i+2*k){
            int start = i;
            int end = Math.min(i+k-1,string.length-1);
            while(start<end){
                char temp = string[start];
                string[start] = string[end];
                string[end] = temp;
                start++;
                end--;
            }
        }
        return new String(string);
    }
}