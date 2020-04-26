package com.leetcode.question94;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorderTraversal(root,list);
        return list;
    }

    private void inorderTraversal(TreeNode root,List list){
        if(root!=null){
            inorderTraversal(root.left,list);
            list.add(root.val);
            inorderTraversal(root.right,list);
        }
    }
}
