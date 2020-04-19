package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Overwrite {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();
        deque.addLast("a");
        deque.addLast("b");
        deque.addLast("c");
        System.out.println(deque);

        String str = deque.peekFirst();
        System.out.println(str);
        System.out.println(deque);

        while(deque.size()>0){
            System.out.println(deque.removeFirst());
        }
        System.out.println(deque);

    }
}
