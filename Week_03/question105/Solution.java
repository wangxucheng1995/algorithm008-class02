package com.leetcode.question105;


import java.util.*;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 初始化转换
        Queue<Integer> preorderQueue = new LinkedList<>();
        for(int i:preorder) preorderQueue.offer(i);
        List<Integer> inorderList = new ArrayList<>();
        for(int j:inorder) inorderList.add(j);

        return buildTreeHelper(preorderQueue,inorderList);
    }

    private TreeNode buildTreeHelper(Queue<Integer> preorder,List<Integer> inorder){
        if(inorder.size()==0||preorder.size()==0)return null;

        int rootElement = preorder.poll();
        TreeNode root = new TreeNode(rootElement);
        int index = inorder.indexOf(rootElement);
        List<Integer> leftPart = inorder.subList(0,index);
        List<Integer> rightPart = inorder.subList(index+1,inorder.size());

        root.left = buildTreeHelper(preorder,leftPart);
        root.right = buildTreeHelper(preorder,rightPart);

        return root;
    }


}
