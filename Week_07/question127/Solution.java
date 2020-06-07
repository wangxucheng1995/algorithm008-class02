package com.leetcode.question127;

import java.util.List;

public class Solution {
    int res = 0;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int len = wordList.size();
        if(len==0) return res;
        boolean[] used = new boolean[len];
        int iter = 1;
        dfs(beginWord,endWord,wordList,used,iter);
        return res;
    }

    private void dfs(String tempWord, String endWord, List<String> wordList, boolean[] used,int iter){
        if(tempWord.equals(endWord)) {
            if(res==0) res = iter;
            else res = Math.min(res,iter);
            return;
        }
        if(iter==wordList.size()) return;

        for(int i=0;i<wordList.size();i++){
            if(diffOneWord(tempWord,wordList.get(i))&&!used[i]){
                used[i] = true;
                iter++;
                dfs(wordList.get(i),endWord,wordList,used,iter);
                iter--;
                used[i] = false;
            }
        }
    }

    private boolean diffOneWord(String tempWord, String s) {
        int diff = 0;
        for(int j=0;j<tempWord.length();j++){
            if(tempWord.charAt(j)!=s.charAt(j)) diff++;
        }
        return diff==1;
    }
}
