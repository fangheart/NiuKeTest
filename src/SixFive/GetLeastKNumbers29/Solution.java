package SixFive.GetLeastKNumbers29;

import java.util.ArrayList;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*
输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
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
    冒泡排序
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        if (input.length<k)
            return arrayList;
        for (int i = 0; i < k; i++) {
            for (int j = input.length-i-1; j >0 ; j--) {
                if (input[j]<input[j-1]){
                    int temp = input[j];
                    input[j] = input[j-1];
                    input[j-1] = temp;
                }
            }
        }
        for (int j = 0; j < k; j++) {
            arrayList.add(input[j]);
        }
        return arrayList;
    }
}