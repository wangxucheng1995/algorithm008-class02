package com.leetcode.question589;

import java.util.*;

public class Solution2 {
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
        Stack<Node> stack = new Stack<>();
        if(root ==null) return list;

        stack.add(root);
        while(!stack.isEmpty()){
            Node temp = stack.pop();
            list.add(temp.val);
            Collections.reverse(temp.children);
            if(!temp.children.isEmpty()){
                for(Node i:temp.children){
                    stack.add(i);
                }
            }
        }
        return list;
    }
}
