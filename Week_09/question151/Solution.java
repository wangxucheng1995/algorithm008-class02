package com.leetcode.question151;

import java.util.Stack;

public class Solution {
    public String reverseWords(String s) {
        String[] words= s.split(" ");
        Stack<String> stack = new Stack<>();
        for(int i=0;i<words.length;i++){
            if(words[i].length()>0) stack.add(words[i]);
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
            if(!stack.isEmpty()) sb.append(" ");
        }
        return sb.toString();
    }
}
