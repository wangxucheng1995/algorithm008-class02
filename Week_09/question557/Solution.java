package com.leetcode.question557;

class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<words.length;i++){
            sb.append(new StringBuilder(words[i]).reverse().toString());
        }
        return sb.toString();
    }
}