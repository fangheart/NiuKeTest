package SixFive.NK39IsBalancedTree;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*
题目描述
输入一棵二叉树，判断该二叉树是否是平衡二叉树。
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
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root==null)
            return true;
        int left = TreeDepth( root.left );
        int right = TreeDepth( root.right );

        int diff = left -right;
        if (diff>1 || diff <-1){
            return false;
        }

        return IsBalanced_Solution( root.left ) && IsBalanced_Solution( root.right );
    }
    public int TreeDepth(TreeNode root) {
        if (root==null)
            return 0;
        int nLeft = TreeDepth( root.left );
        int nRight = TreeDepth( root.right );

        return (nLeft > nRight ? nLeft+1 : nRight + 1);
    }

    //方法二只需遍历一次

//后续遍历时，遍历到一个节点，其左右子树已经遍历  依次自底向上判断，每个节点只需要遍历一次
    private boolean isBalanced=true;
    public boolean IsBalanced_Solution2(TreeNode root) {
        getDepth(root);
        return isBalanced;
    }
    public int getDepth(TreeNode root){
        if(root==null)
            return 0;
        int left=getDepth(root.left);
        int right=getDepth(root.right);
        if(Math.abs(left-right)>1){
            isBalanced=false;
        }
        return right>left ?right+1:left+1;
        }
}