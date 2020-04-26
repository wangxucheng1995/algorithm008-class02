package com.leetcode.question589;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> preorder(Node root) {
        List<Integer> list = new LinkedList<>();
        preorder(root,list);
        return list;
    }

    private void preorder(Node root,List<Integer> list){
        if (root ==null)return;
        list.add(root.val);
        if(root.children.isEmpty())return;
        for(Node i:root.children){
            preorder(i,list);
        }
    }
}
