package com.leetcode.question21;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
     public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        Queue<Integer> queue = new LinkedList<>();
        ListNode left = l1;
        ListNode right = l2;
        if(left==null&&right==null)return null;

         while(left!=null&&right!=null){
             while (left!=null&&left.val<right.val){
                 queue.add(left.val);
                 left = left.next;
             }

             if(left==null)break;

             while(right!=null&&right.val<=left.val){
                 queue.add(right.val);
                 right = right.next;
             }
             if (right==null)break;
         }
        if(left==null){
            while(right!=null){
                queue.add(right.val);
                right = right.next;
            }
        }
        if(right==null){
            while(left!=null){
                queue.add(left.val);
                left=left.next;
            }
        }

        ListNode answer = new ListNode(queue.poll());
        ListNode cur = answer;
        while(!queue.isEmpty()){
            cur.next = new ListNode(queue.poll());
            cur = cur.next;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        solution.mergeTwoLists(l1,l2);
    }
}
