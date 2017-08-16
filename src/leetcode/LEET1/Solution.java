package leetcode.LEET1;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*
题目描述
Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
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
    public int run(TreeNode root) {if(root==null)
        return 0;
        if(root.left==null)
            return run(root.right)+1;
        if(root.right==null)
            return run(root.left)+1;
        int nLeft = run(root.left);
        int nRight = run(root.right);

        return (nLeft<nRight ? nLeft+1 : nRight+1);
    }

}