package SixFive.NK58isSymmetricalTree;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*

请实现一个函数，用来判断一颗二叉树是不是对称的。
注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
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
    boolean isSymmetrical(TreeNode pRoot){
        return isSymmetrical(pRoot,pRoot);
    }

    private boolean isSymmetrical(TreeNode pRoot, TreeNode pRoot1) {
        if (pRoot==null&&pRoot1==null)
            return true;
        if (pRoot==null||pRoot1==null)
            return false;
        if (pRoot.val!=pRoot1.val)
            return false;

        return isSymmetrical(pRoot.left,pRoot1.right)
                &&isSymmetrical(pRoot.right,pRoot1.left);
    }

}