package SixFive.MoreThanHalfNumInArray28;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*
题目描述
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
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
       时间复杂度为O(N)利用数组的特性来进行
  在遍历数组时保存两个值：一是数组中一个数字，一是次数。
  遍历下一个数字时，若它与之前保存的数字相同，则次数加1，否则次数减1；
  若次数为0，则保存下一个数字，并将次数置为1。
  遍历结束后，所保存的数字即为所求。然后再判断它是否符合条件即可。
     */
    public int MoreThanHalfNum_Solution(int [] array) {
        int result = array[0];
        int times = 1;
        if(array==null||array.length<=0){
            return 0;
        }
        for (int i = 1; i < array.length; i++) {
            if (times==0){
                result = array[i];
                times = 1;
            }else if (array[i]==result){
                times++;
            }else {
                times--;
            }
        }
        times = 0;
        for (int i = 0; i < array.length; i++) {
            if (result==array[i]){
                times++;
            }
        }
        if (times*2 <= array.length)
            result  = 0;
        return result;
    }
    /*
    用HashMap O(N)，用桶排序方法也可
     */
    public int MoreThanHalfNum_Solution2(int [] array) {
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])){
                map.put(array[i],1);
            }else {
                int count = map.get(array[i]);
                count++;
                map.put(array[i],count);
            }
        }
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            int key = (int) entry.getKey();
            int val = (int) entry.getValue();
            if (val>array.length/2){
                return key;
            }
        }
        return 0;
    }
    /*
    用快排思想，也就是找到中位数,时间复杂度过大
     */
    public int MoreThanHalfNum_Solution3(int [] array) {
        if (array.length<=0)
            return 0;

        int start = 0;
        int end = array.length - 1;
        int mid = (end-start)/2;

        int index = partition(array,start,end);

        while (index!=mid){
            if (index>mid){
                index = partition(array,start,index-1);
            }else {
                index = partition(array,index+1,end);
            }
        }

        int result = array[mid];
        int times = 0;
        for (int i = 0; i < array.length; i++) {
            if (result==array[i]){
                times++;
            }
        }
        if (times*2 <= array.length)
            result  = 0;
        return result;
    }

    private int partition(int[] array, int start, int end) {
        int flag = array[start];
        int ff = start;
        while (start!=end) {
            while (array[end] >= flag && start < end) {
                end--;
            }
            while (array[start] < flag && start < end) {
                flag++;
            }
            if (start < end) {
                int t = array[start];
                array[start] = array[end];
                array[end] = t;
            }
        }
        int temp = array[start];
        array[start] = flag;
        array[ff] = temp;

        return start;
    }
}