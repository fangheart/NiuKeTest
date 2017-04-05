package SixFive.NK38TreeDepth;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*
输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度
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
    public int TreeDepth(TreeNode root) {
        if (root==null)
            return 0;
        int nLeft = TreeDepth( root.left );
        int nRight = TreeDepth( root.right );

        return (nLeft > nRight ? nLeft+1 : nRight + 1);
    }

}