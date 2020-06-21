package com.leetcode.question205;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> pair = new HashMap<>();
        HashSet<Character> used = new HashSet<>();

        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();

        if(str1.length!=str2.length) return false;

        for(int i=0;i<str1.length;i++){
            if(!pair.containsKey(str1[i])){
                if(used.contains(str2[i])) return false;
                else {
                    pair.put(str1[i],str2[i]);
                    used.add(str2[i]);
                }
            }else {
                if(pair.get(str1[i])!=str2[i]) return false;
            }
        }
        return true;
    }
}
