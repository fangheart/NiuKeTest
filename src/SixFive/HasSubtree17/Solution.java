package SixFive.HasSubtree17;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*
输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
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
递归法求解
     */
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        if (root1==null || root2==null)
            return false;
        else {
            if(root1.val==root2.val){
                result = DoesTree1HaveTree2(root1,root2);
            }
            if (!result)
                result = DoesTree1HaveTree2(root1.left,root2);
            if (!result)
                result = DoesTree1HaveTree2(root1.right,root2);
        }
        return result;
    }

    public boolean DoesTree1HaveTree2(TreeNode root1,TreeNode root2){
        if(root1 == null && root2 != null)
            return false;
        if(root2 == null)
            return true;
        if(root1.val != root2.val)
            return false;
        return DoesTree1HaveTree2(root1.left, root2.left) && DoesTree1HaveTree2(root1.right, root2.right);
        }
}