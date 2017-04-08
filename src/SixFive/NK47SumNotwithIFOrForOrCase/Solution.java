package SixFive.NK47SumNotwithIFOrForOrCase;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*
题目描述
求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
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
&&就是逻辑与，逻辑与有个短路特点，前面为假，后面不计算
     */
    public int Sum_Solution(int n) {
        int ans = n;
        boolean a;
        a= ans>=1 && (ans+=Sum_Solution( n-1 ))>=0;
        return ans;
    }
}