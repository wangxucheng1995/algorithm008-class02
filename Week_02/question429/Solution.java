package com.leetcode.question429;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new LinkedList<>();
        levelOrder(list, root);
        return list;
    }

    private void levelOrder(List<List<Integer>> list, Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
            int s = queue.size();
            int count = 0;
            List<Integer> tempList = new LinkedList<>();

            while (!queue.isEmpty()) {
                Node temp = queue.poll();
                tempList.add(temp.val);
                count++;
                if (temp.children != null) {
                    queue.addAll(temp.children);
                }
                if (count == s) {
                    count = 0;
                    s = queue.size();
                    list.add(tempList);
                    tempList = new LinkedList<>();
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Node> list = new LinkedList<>();
        Node node2 = new Node(3);
        Node node3 = new Node(2);
        Node node4 = new Node(4);
        list.add(node2);
        list.add(node3);
        list.add(node4);
        Node node = new Node(1,list);

        Solution solution = new Solution();
        List<List<Integer>> a = solution.levelOrder(node );
        for(List<Integer> j:a){
            for(int i: j){
                System.out.println(i);
            }
        }
    }

}
