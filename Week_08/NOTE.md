# 第八周学习总结
自己把排序算法写了一下

## 归并排序

```java
import java.util.Arrays;

public class MergeSort {
    public void sort(int[] arr){
        //输入一个组数，对于给定的
        __sort(arr,0,arr.length-1);
    }

    //输入一个组数，对于给定的[left, right]闭区间内进行排序。
    private void __sort(int[] arr,int left, int right){
        if(left>=right) return;

        int mid = (left+right)/2;
        __sort(arr,left,mid);
        __sort(arr,mid+1,right);
        if(arr[mid]>arr[mid+1])
            merge(arr,left,mid,right);
    }

    //对数组的[left..mid]以及[mid+1...right]部分进行合并
    private void merge(int[] arr,int left,int mid, int right){
        int[] aux = Arrays.copyOfRange(arr,left,right+1); //辅助用数组
        //辅助用下标
        int l = 0;
        int m = mid-left;
        int rl = m+1;
        int r = right-left;
        for (int x=left;x<=right;x++){
            if(l>m){
                arr[x] = aux[rl];
                rl++;
            }else if(rl>r){
                arr[x] = aux[l];
                l++;
            }else if(aux[l]<aux[rl]){
                arr[x] = aux[l];
                l++;
            }else {
                arr[x] = aux[rl];
                rl++;
            }
        }
    }

    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        int[] a = new int[]{2,45,31,24,409,1,24,241,3532,21};
        ms.sort(a);
        for(int i:a){
            System.out.println(i);
        }
    }
}
```

## 快速排序-单路快排

```java
public class QuickSort2 {
    public void sort(int[] arr) {
        __sort(arr, 0, arr.length - 1);
    }

    //对[left...right]的部分进行经行快速排序
    private void __sort(int[] arr, int left, int right) {
        if (left >= right) return;

        int p = partition(arr, left, right);
        __sort(arr, left, p - 1);
        __sort(arr, p + 1, right);
    }

    //完成left到right的排序，将头元素放入中间位置，并输出该位置
    private int partition(int[] arr, int left, int right) {
        int v = arr[left]; //将标定元素
        int j = left; //从[left+1...j]的部分为小于v的值
        int i = left + 1;//从[j+1...i)的部分为大于等于v的值
        for (; i <= right; i++) {
            if (arr[i] < v) {
                j++;
                swap(arr, i, j);
            }
        }
        swap(arr, left, j);
        return j;
    }

    private void swap(int[] arr, int i, int j) {
        if (i == j) return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
```

## 快速排序-双路快排
```java
public class twoWaysQuickSort {
    public void sort(int[] arr) {
        __sort(arr, 0, arr.length - 1);
    }

    //对[left...right]的部分进行经行快速排序
    private void __sort(int[] arr, int left, int right) {
        if (left >= right) return;

        int p = partition(arr, left, right);
        __sort(arr, left, p - 1);
        __sort(arr, p + 1, right);
    }

    //完成left到right的排序，将头元素放入中间位置，并输出该位置
    private int partition(int[] arr, int left, int right) {
        //[left+1...i)<=v  (j...right]>=v
        int v = arr[left];
        int i=left+1;
        int j=right;
        while (true){
            while (i<=right && arr[i]<v)i++;
            while (j>=left+1&& arr[j]>v)j--;
            if(i>j)break;
            swap(arr,i,j);
            i++;
            j--;
        }
        swap(arr,left,j);

        return j;
    }

    private void swap(int[] arr, int i, int j) {
        if (i == j) return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        twoWaysQuickSort tws = new twoWaysQuickSort();
        int[] a = new int[]{2,45,31,24,409,1,24,241,3532,21};
        tws.sort(a);
        for(int i:a){
            System.out.println(i);
        }
    }
}

```

## 快速排序-三路快排
```java
public class ThreeWaysQuickSort {
    public void sort(int[] arr) {
        __sort(arr, 0, arr.length - 1);
    }

    private void __sort(int[] arr, int left, int right) {
        if (left >= right) return;

        int v = arr[left];
        int lt = left;//arr[l+1...lt]<v
        int gt = right + 1;//arr[gt...rignt]>v
        int i = left + 1;//arr[lt+1..i)==v
        while (i < gt) {
            if (arr[i] < v) {
                lt++;
                swap(arr, lt, i);
                i++;
            } else if (arr[i] > v) {
                swap(arr, i, gt - 1);
                gt--;
            } else {
                i++;
            }
        }
        swap(arr, left, lt);
        __sort(arr, left, lt - 1);
        __sort(arr, gt, right);
    }

    private void swap(int[] arr, int i, int j) {
        if (i == j) return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        ThreeWaysQuickSort ts = new ThreeWaysQuickSort();
        int[] a = new int[]{2, 45, 31, 24, 409, 1, 24, 241, 3532, 21};
        ts.sort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
```

