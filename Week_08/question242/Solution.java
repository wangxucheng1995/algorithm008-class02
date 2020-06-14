package com.leetcode.question242;

import java.util.HashMap;
import java.util.Hashtable;

public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char temp = s.charAt(i);
            if(map.containsKey(temp)){
                int count = map.get(temp);
                map.put(temp,count+1);
            }else{
                map.put(temp,1);
            }
        }

        for(int j=0;j<t.length();j++){
            char checkChar = t.charAt(j);
            if(!map.containsKey(checkChar))return false;
            int count = map.get(checkChar);
            if(count <=0 ) return false;
            map.put(checkChar,count-1);
        }

        for(Integer values:map.values()){
            if(values!=0)return false;
        }
        return true;
    }
}
