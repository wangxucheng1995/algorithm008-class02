package com.leetcode.question77;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int[] number = new int[n];
        for(int i=0;i<n;i++){
            number[i] = i+1;
        }
        create(number,k,temp,answer,0);
        return answer;
    }

    public void create(int[] number, int k,List<Integer> temp,List<List<Integer>> answer,int cur){
        if(temp.size()==k) {
            answer.add(new ArrayList<>(temp));
            return;
        }

        for(int i=cur;i<number.length;i++){
                temp.add(number[i]);
                create(number,k,temp,answer,i+1);
                temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.combine(4,2);
    }
}
