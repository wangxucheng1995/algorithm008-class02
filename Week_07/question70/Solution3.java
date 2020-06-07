package com.leetcode.question70;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution3 {
    public void climbStairs(int n) {
        HashMap<Integer, ArrayList<String>> jumpHistory = new HashMap<>();
        ArrayList<String> list_zero = new ArrayList<>();
        list_zero.add("0");
        jumpHistory.put(0, list_zero);

        ArrayList<String> list_one = new ArrayList<>();
        list_one.add("01");
        jumpHistory.put(1, list_one);

        ArrayList<String> list_two = new ArrayList<>();
        list_two.add("02");
        jumpHistory.put(2, list_two);

        for (int i = 3; i <= n; i++) {
            ArrayList<String> res = new ArrayList<>();
            List<String> disThreeStep = jumpHistory.get(i - 3);
            for (String s : disThreeStep) {
                if (s.charAt(s.length() - 1) != '3') res.add(s + '3');
            }

            List<String> disTwoStep = jumpHistory.get(i - 2);
            for (String s : disTwoStep) {
                if (s.charAt(s.length() - 1) != '2') res.add(s + '2');
            }

            List<String> disOneStep = jumpHistory.get(i - 1);
            for (String s : disOneStep) {
                if (s.charAt(s.length() - 1) != '1') res.add(s + '1');
            }
            jumpHistory.put(i, res);
        }

        ArrayList<String> answer = jumpHistory.get(n);
        System.out.println(answer);
        System.out.println("一共有以上" + answer.size() + "种走法");
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        solution3.climbStairs(6);
    }
}
