package com.leetcode.question22;

import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> answer = new ArrayList<>();
        generate(new char[2*n],0,answer);
        return answer;
    }

    public void generate(char[] array,int cur,List<String> answer){
        if(cur==array.length){
            if(valid(array))
                answer.add(new String(array));
        }else {
            array[cur] = '(';
            generate(array,cur+1,answer);
            array[cur] = ')';
            generate(array,cur+1,answer);
        }
    }

    public boolean valid(char[] current) {
        int balance = 0;
        for (char c: current) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return (balance == 0);
    }
}
