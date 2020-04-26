package com.leetcode.question347;

public class Maxheap<E extends Comparable> {
    private Array<E> data;

    public Maxheap(int capacity) {
        data = new Array<>(capacity);
    }

    public Maxheap() {
        data = new Array<>();
    }

    public Maxheap(E[] arr){
        data = new Array<>(arr);
        for(int i = parent(arr.length-1);i>=0;i--){
            shiftDown(i);
        }
    }

    //返回堆中的元素个数
    public int size() {
        return data.getSize();
    }

    //返回一个布尔值，表示堆中是否为空
    public boolean isEmpty() {
        return data.isEmpty();
    }

    //返回一个索引所表示的元素的父亲节点的缩影
    private int parent(int index) {
        if (index == 0)
            throw new IllegalArgumentException("index-0 does not have parent");
        return (index - 1) / 2;
    }

    //返回一个索引所表示元素的左孩子的节点的索引
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }

    public void add(E e) {
        data.addLast(e);
        shiftUp(data.getSize() - 1);
    }

    private void shiftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    //查看目前堆中的最大元素
    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("heap is empty");
        }
        return data.get(0);
    }

    public E extractMax() {
        E ret = findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        shiftDown(0);
        return ret;
    }

    private void shiftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0)
                j = rightChild(k);
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }
            data.swap(k, j);
            k = j;
        }
    }

    //取出堆中的最大元素，并且替换成元素e
    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        shiftDown(0);
        return ret;
    }


}
