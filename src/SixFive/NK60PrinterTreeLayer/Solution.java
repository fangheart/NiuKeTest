package SixFive.NK60PrinterTreeLayer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*
题目描述
从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
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
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        if (pRoot==null)
            return arrayLists;
        ArrayList<Integer> arrayList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        int start=0,end = 1;
        while (!queue.isEmpty()){
            TreeNode p = queue.poll();
            arrayList.add(p.val);
            start++;
            if (p.left!=null)
                queue.add(p.left);
            if (p.right!=null)
                queue.add(p.right);

            if (start==end){
                end = queue.size();
                start = 0;
                arrayLists.add(arrayList);
                arrayList = new ArrayList<>();
            }
        }

        return arrayLists;

    }

}