# 第一周的学习总结
*核心内容*

- 数组
- 链表
- 跳表


----
 ## 课程内容

数据结构|增|删|改|查
-------|:-:|:-:|:-:|:-:|
数组|O(n)|o(n)|o(1)|o(1)|
链表|o(1)|o(1)|o(n)|o(n)|

说明:当数组的头部增加或者删除一个元素，需要将后面的元素向前或向后移动，故平均需要消耗o(n)的时间复杂度。而改查方面，当我们知道元素所在的索引位置时，通过索引o(1)的时间复杂度，便可找到需要查询的元素。

---

## 习题总结

1.移动零:数组中使用的**双指针**技巧

2.环形链表:**快慢指针**技巧

3.爬楼梯: 对于动态规划问题，可以通过添加一个数组(或者哈希表)来存储已经求解过的答案，从而减少递归的运算。


## 作业

- 用 add first 或 add last 这套新的 API 改写 Deque 的代码

[作业地址](https://github.com/wangxucheng1995/algorithm008-class02/blob/master/Week_01/Overwrite.java)

- 分析 Queue 和 Priority Queue 的源码

java中的PriorityQueue通过二叉小顶堆实现

### 添加操作-offer方法

#### 图解

![image](offer.png)

#### 代码

```java
//offer(E e)
public boolean offer(E e) {
    if (e == null)//不允许放入null元素
        throw new NullPointerException();
    modCount++;
    int i = size;
    if (i >= queue.length)
        grow(i + 1);//自动扩容
    size = i + 1;
    if (i == 0)//队列原来为空，这是插入的第一个元素
        queue[0] = e;
    else
        siftUp(i, e);//调整
    return true;
}
```

其中shiftUp的代码为

```java
//siftUp()
private void siftUp(int k, E x) {
    while (k > 0) {
        int parent = (k - 1) >>> 1;//parentNo = (nodeNo-1)/2
        Object e = queue[parent];
        if (comparator.compare(x, (E) e) >= 0)//调用比较器的比较方法
            break;
        queue[k] = e;
        k = parent;
    }
    queue[k] = x;
}
```

### 删除操作-poll方法

#### 图解

![image](poll.png)

#### 代码

```java
public E poll() {
    if (size == 0)
        return null;
    int s = --size;
    modCount++;
    E result = (E) queue[0];//0下标处的那个元素就是最小的那个
    E x = (E) queue[s];
    queue[s] = null;
    if (s != 0)
        siftDown(0, x);//调整
    return result;
}
```

其中shiftDown的代码为

```java
//siftDown()
private void siftDown(int k, E x) {
    int half = size >>> 1;
    while (k < half) {
    	//首先找到左右孩子中较小的那个，记录到c里，并用child记录其下标
        int child = (k << 1) + 1;//leftNo = parentNo*2+1
        Object c = queue[child];
        int right = child + 1;
        if (right < size &&
            comparator.compare((E) c, (E) queue[right]) > 0)
            c = queue[child = right];
        if (comparator.compare(x, (E) c) <= 0)
            break;
        queue[k] = c;//然后用c取代原来的值
        k = child;
    }
    queue[k] = x;
}
```

入堆与出堆的时间复杂度均为**O(logn)**










