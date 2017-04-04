package SixFive.FindNumbersWithSum42;

import java.util.ArrayList;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*
题目描述
输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
输出描述:
对应每个测试案例，输出两个数，小的先输出。
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

     */
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> arrayList = new ArrayList<>(  );
        if (array==null || sum==0)
            return arrayList;

        int start = 0;
        int end = array.length-1;
        int curSum = array[start] + array[end];
        while (start<=end) {
            if (curSum == sum) {
                arrayList.add( array[start] );
                arrayList.add( array[end] );
                break;
            } else if (curSum > sum) {
                end--;
            } else {
                start++;
            }
            curSum = array[start] + array[end];
        }
        return arrayList;
    }
}