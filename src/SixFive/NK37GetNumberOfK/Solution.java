package SixFive.NK37GetNumberOfK;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*
题目描述
统计一个数字在排序数组中出现的次数。
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
    public static void main(String[] args) {

    }

    /*

     */
    public int GetNumberOfK(int[] array, int k) {
        int first = getFirstK( array, k, 0, array.length - 1 );
        int end = getLastK( array, k, 0, array.length - 1 );
        if (first!=-1 && end!=-1)
            return end - first + 1;
        else
            return 0;
    }

    public int getFirstK(int[] array, int k, int start, int end) {
        if (end < start)
            return -1;
        int mid = (start + end) >> 1;
        if (k>array[mid]){
            return getFirstK( array,k,mid+1,end );
        }else if (k<array[mid]){
            return getFirstK( array,k,start,mid-1 );
        }else if (mid-1>=0 && array[mid-1]==k){
            return getFirstK( array,k,start,mid-1 );
        }else {
            return mid;
        }
    }

    public int getLastK(int[] array, int k, int start, int end) {
        if (end < start)
            return -1;
        int mid = (start + end) >> 1;
        if (k > array[mid]) {
            return getLastK( array, k, mid + 1, end );
        } else if (k < array[mid]) {
            return getLastK( array, k, start, mid - 1 );
        } else if (mid + 1 <= array.length - 1 && array[mid + 1] == k) {
            return getLastK( array, k, mid + 1, end );
        } else {
            return mid;
        }
    }
}