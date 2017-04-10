package SixFive.NK59PrinterTreeReverselayer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*
题目描述
请实现一个函数按照之字形打印二叉树，
即第一行按照从左到右的顺序打印，
第二层按照从右至左的顺序打印，
第三行按照从左到右的顺序打印，其他行以此类推。
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
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        if (pRoot==null)
            return arrayLists;
        ArrayList<Integer> arrayList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        int start=0,end = 1;
        boolean leftToRght = true;

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
                if (leftToRght) {
                    arrayLists.add(arrayList);
                }
                if (!leftToRght){
                    arrayLists.add(reverse(arrayList));
                }
                leftToRght=!leftToRght;
                arrayList = new ArrayList<>();
            }
        }

        return arrayLists;
    }

    public ArrayList<Integer> reverse(ArrayList<Integer> arrayList) {
        int len = arrayList.size();
        ArrayList<Integer> reverseArrayList = new ArrayList<>();
        for (int i = len-1; i >=0 ; i--) {
            reverseArrayList.add(arrayList.get(i));
        }
        return reverseArrayList;
    }

}