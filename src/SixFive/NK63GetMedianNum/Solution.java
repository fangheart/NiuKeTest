package SixFive.NK63GetMedianNum;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*
题目描述
如何得到一个数据流中的中位数？
如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public static void main(String[] args){

    }
    /*
Java的PriorityQueue是从JDK1.5开始提供的新的数据结构接口，默认内部是自然排序，结果为小顶堆，
也可以自定义排序器，比如下面反转比较，完成大顶堆。
思路：为了保证插入新数据和取中位数的时间效率都高效，这里使用大顶堆+小顶堆的容器，并且满足：
1、两个堆中的数据数目差不能超过1，这样可以使中位数只会出现在两个堆的交接处；
2、大顶堆的所有数据都小于小顶堆，这样就满足了排序要求。
     */

    private int count = 0;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    //priority默认是小顶堆所以需要重写comparator翻转他
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(15, new Comparator<Integer>() {
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
    }});
    public void Insert(Integer num) {
        if (count %2 == 0) {//当数据总数为偶数时，新加入的元素，应当进入小根堆        
            // （注意不是直接进入小根堆，而是经大根堆筛选后取大根堆中最大元素进入小根堆）        
            // 1.新加入的元素先入到大根堆，由大根堆筛选出堆中最大的元素
            maxHeap.offer(num);
            int filteredMaxNum = maxHeap.poll();
            //2.筛选后的【大根堆中的最大元素】进入小根堆        
            minHeap.offer(filteredMaxNum);
        } else {//当数据总数为奇数时，新加入的元素，应当进入大根堆        
            // （注意不是直接进入大根堆，而是经小根堆筛选后取小根堆中最大元素进入大根堆）
            //1.新加入的元素先入到小根堆，由小根堆筛选出堆中最小的元素        
            minHeap.offer(num);
            int filteredMinNum = minHeap.poll();
            //2.筛选后的【小根堆中的最小元素】进入小根堆
            maxHeap.offer(filteredMinNum);
        }
        count++;
    }
        public Double GetMedian() {
        if (count %2 == 0) {
            return new Double((minHeap.peek() + maxHeap.peek())) / 2;
        } else {
            return new Double(minHeap.peek());
        }
    }

}