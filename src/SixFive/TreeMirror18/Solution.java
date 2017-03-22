package SixFive.TreeMirror18;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*

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
    public void Mirror(TreeNode root) {
        TreeNode tmp = null;
        if (root!=null){
            tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            if (root.left!=null)
                Mirror(root.left);
            if (root.right!=null)
            Mirror(root.right);

        }
    }
}