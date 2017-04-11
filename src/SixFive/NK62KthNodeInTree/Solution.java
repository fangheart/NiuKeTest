package SixFive.NK62KthNodeInTree;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*
题目描述
给定一颗二叉搜索树，请找出其中的第k大的结点。例如，
            5
         /     \
        3       7
      /  \     /  \
     2    4   6    8 中，
     按结点数值大小顺序第三个结点的值为4。
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
    中序遍历得到的就是一个递增序列，只要我们按照中序遍历，第K个元素就是我们要找的元素
     */
    int index = 0;//计数器
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot==null||k<=0)
            return null;
        if (pRoot!=null){
            TreeNode node = KthNode( pRoot.left,k );
            if (node!=null)
                return node;
            index++;
            if (index==k)
                return pRoot;
            node = KthNode( pRoot.right,k );
            if (node!=null)
                return node;
        }
        return null;
    }

}