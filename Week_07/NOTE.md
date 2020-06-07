# 第7周学习总结
时间忙，PPT做的图略潦草，请见谅

## 1.为什么需要并查集
并查集可以快速解决联通问题。比如我们想知道像下面这张图中，任意两点是否相连，我们当然可以通过bfs与dfs求出链接的路径。但是这样做我们就多做了一些事情，因为我们其实并不需要知道他们之间是具体如何相连，而是想知道他们之间是否相连，所以答案只需回答yes或者no即可。而并查集就可以快速回答这个问题。

<image src="images\union1.png" width=400px>

<!-- more -->

## 2.并查集的两个基本需求
**需求一** **union(p,q)**

将指定的p与q两个元素合并在一起。

**需求二** **isConnected(p,q)**

检查两个元素p与q是否相连

## 3.简单的并查集(数组)

<image src="images\union2.png" width=400px>

假如我们现在有一个容量为10的数组，上层为元素的id，下层为集合的id。那么编号0，2，4...为一类的事物(集合编号0)，而1，3，5为另一类的事物(集合编号1)。

那么检查p，q两个元素是否为同一类时，只要取出数组中保存的集合id,并检查他们是否相等就行了。代码为
```java
    private int find(int p){
        if(p<0 && p>=id.length)
            throw new IllegalArgumentException("p is out of bound");
        return id[p];
    }

    @Override
    public boolean isConnected(int p, int q){
        return find(p) == find(q);
    }
```
检查isConnected方法的复杂度为O(1).

当我们做union(1,4)时，表示我们需要把1所代表的集合与4所代表的集合融合起来。我们需要找到所有原来与1编号相同的集合内的元素，并将他们所对应的集合编号进行统一的修改，如图。

<image src="images\union3.png" width=400px>

```java
    @Override
    public void unionElements(int p, int q){
        int pID = find(p);
        int qID = find(q);

        if(pID==qID) return;

        for(int i=0;i<id.length;i++){
            if(id[i]==pID)
                id[i] = qID;
        }
    }
```
融合方法(并操作)方法的复杂度为O(n).
检查是否连接的方法为o(1)

## 4.真正的并查集(Quick Union)

### 一 : 基本思想
我们现在把每一个元素都看成了一个节点。并且每个节点都有一个指针，指针指向了节点的根节点。当我们在做合并操作时，我们只需要把新加入的节点指向原节点的根节点即可。如图

将如我们想把节点3与节点2做一个合并，我们就将节点3直接指向节点2的根节点(1)。

<image src="images\union4.png" width=200px>

假如3节点已有根节点，那么我们就先找到3的根节点4，并将4指向2的根节点1。如图

<image src="images\union5.png" width=200px>
<image src="images\union6.png" width=200px>

### 二 : 基于数组的实现

<image src="images\union7.png" width=400px>

假如我们初始的数组中存放着5个元素，我们可以将元素分别指向他们自身。当我们做union(3,4)时，就将3指向4。

<image src="images\union8.png" width=400px>

再经过一些操作之后呢，我们的情况如下图

<image src="images\union9.png" width=400px>

如果我们此时做union(0,3)的话
我们就找到0的根节点，再找到3的根节点，把0的根，指向3的根

<image src="images\union10.png" width=400px>

```java
private int find(int p) {
        if (p < 0 && p >= parent.length)
            throw new IllegalArgumentException("p is out of bound.");
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        parent[pRoot] = qRoot;
    }
```
*说明:找到p的根节点，将p的根节点指向q的根节点*

所以当我们需要考察两个元素是否为同一集合的节点时，我们只要找到他们的根节点，并且比较他们的根节点是否相同即可。
isConnected操作的代码为:

```java
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
```
此时isConnected(查操作)为O(h),h表示两个2节点所在的最大深度。<br>
而union(并操作)也为O(h)。

## 两种优化思路

### 一  基于rank的优化

假如我们今天要合并以下的两棵树，其中一颗树的高度为3，另一棵树的高度2，当我们做union(4,1)时，就形成了一颗高度为4的树，但其实我们本可以让根节点0指向2形成一颗高度为3的树。(这样在后期做查询操作时就可以更加高效)，所以现在在做并操作时就需要考虑两个树各自的深度。

<image src="images\union11.png" width=200px>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<image src="images\union12.png" width=200px>

我们使用一个额外的数组rank来表示根节点所对应的那颗树的深度。在比较时我们总将深度较低的那颗树指向较高树的节点。当深度相同时，则将右边的树指向左边的树，并将左边树的深度+1

```java
  @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;

        if(rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if( rank[qRoot] < rank[pRoot])
            parent[qRoot] = pRoot;
        else {
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
        }
    }
```

### 二  路径压缩

在下面两张图中分别有5个节点，他们之间的表示关系是完全等价的，但是由于左边的树高于右边的树，所以在做find操作时，右边的性能是明显好于左边的。<br>
所以我们就提出一种想法，能不能让左边这样的结构压缩成右边这样的,其实只需要我们在查找的过程中，让当前节点指向它父亲的父亲节点就可以了。具体操作如下

<image src="images\union13.png" width=400px>

```java
    private int find(int p) {
        if (p < 0 && p >= parent.length)
            throw new IllegalArgumentException("p is out of bound.");
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
```
在查找的过程中就实现了路径的压缩。<br>
并与查的操作的时间复杂度为O(log\*n)  *(大于o(1)小于o(logn)的一种时间复杂度*

# 对于平衡二叉树的一些简单总结

## 1.什么是平衡二叉树
**对于任意一个节点，左子树和右子树的高度差不能超过1**
<font size=2px>一个节点的高度=max(左子树高度，右子树高度)+1</font>

所以我们引入了平衡因子这个概念，平衡因子 = 左子树高度-右子树的高度

<image src="images\AVL1.png" width=400px>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<image src="images\AVL2.png" width=400px>

左右两张图分别是各个结点的的高度与平衡因子。
<!-- more -->
## 2.基本旋转操作

### 一 右旋操作(LL)
Q.何时需要右旋？<br>
之前均为平衡状态，当在左侧添加一个节点之后，一颗树(或者子树)的根节点的负载因子大于1，并且它的左节点的负载因子大于等于0，说明整棵树的结构是向左倾斜的。

<image src="images\AVL3.png" width=400px>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<image src="images\AVL4.png" width=400px>

我们让y的右节点接上x，并让x的左节点指向t3，此时这棵树既满足了两分搜索树的性质，又满足了平衡二叉树的性质。<br>
(这边让t的高度都相同了，但如果t之间的高度不同其实依然满足平衡的性质，这边就不详细证明了。)

### 二 左旋操作(RR)
Q.何时需要左旋操作。<br>
当在右侧添加一个节点之后，一颗树(或者子树)的根节点的负载因子小于-1，并且它的左节点的负载因子小于等于0，说明整棵树的结构是向右倾斜的。

<image src="images\AVL5.png" width=400px>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<image src="images\AVL6.png" width=400px>

X.left = Y Y.right = T3 操作之后，此时树既满足了两分搜索树的性质，又满足了平衡二叉树的性质。

### 三 LR

当我们添加一个节点导致根节点不平衡，并且添加的位置位于左孩子的右侧，此时我们就形成了LR的情况。我们对x节点经行一次左旋转，将问题转换为了LL。并依照之前处理LL的情况处理。
<image src="images\AVL7.png" width=600px>

### 四 RL
同理可得，先对x右旋再对整体左旋

<image src="images\AVL8.png" width=600px>
