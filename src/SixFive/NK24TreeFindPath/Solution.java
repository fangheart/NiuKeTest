package SixFive.NK24TreeFindPath;

import java.util.ArrayList;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*
输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
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
递归解法
     */
    ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root==null)
            return listAll;
        list.add(root.val);
        target = target - root.val;
        if (target==0 && root.left==null && root.right==null)
            listAll.add(new ArrayList<Integer>(list));
        FindPath(root.left,target);
        FindPath(root.right,target);
        //如果到叶子节点找不到那么就要回退
        list.remove(list.size()-1);
        return listAll;
    }
}