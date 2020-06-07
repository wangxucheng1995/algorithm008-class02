package com.leetcode.question127;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution2 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList==null)return 0;
        boolean[] used = new boolean[wordList.size()];
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int len = queue.size();
        int count = 0;
        int deep = 1;

        while(!queue.isEmpty()){
            String tempWord = queue.remove();
            if(tempWord.equals(endWord)) return deep;
            for(int i=0;i<wordList.size();i++){
                if(oneWordDiff(wordList.get(i),tempWord) && !used[i]){
                    queue.add(wordList.get(i));
                    used[i] = true;
                }

            }
            count++;
            if(count==len){
                count=0;
                len = queue.size();
                deep++;
            }
        }
        return 0;
    }

    private boolean oneWordDiff(String s, String tempWord) {
        int diff = 0;
        for(int j=0;j<s.length();j++){
            if(s.charAt(j)!=tempWord.charAt(j)) diff++;
        }
        return diff==1;
    }
}
