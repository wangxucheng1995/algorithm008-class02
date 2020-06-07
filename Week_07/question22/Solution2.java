package com.leetcode.question22;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> answer = new ArrayList<>();
        generate(answer,new StringBuilder(),0,0,n);
        return answer;
    }

    public void generate(List<String> answer,StringBuilder c,int open,int close,int max){
        if(c.length()==max*2){
            answer.add(c.toString());
            return;
        }

        if(open<max){
            c.append('(');
            generate(answer,c,open+1,close,max);
            c.deleteCharAt(c.length()-1);
        }
        if(close<open){
            c.append(')');
            generate(answer,c,open,close+1,max);
            c.deleteCharAt(c.length()-1);
        }
    }
}
