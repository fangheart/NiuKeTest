package SixFive.TreeConvert26;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*
题目描述
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
例如                   10
                      /  \
                     6   14
                    / \  /  \
                   4   8 12  16
更改为4=6=8=10=12=14=16
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
1.将左子树构造成双链表，并返回链表头节点。
2.定位至左子树双链表最后一个节点。
3.如果左子树链表不为空的话，将当前root追加到左子树链表。
4.将右子树构造成双链表，并返回链表头节点。
5.如果右子树链表不为空的话，将该链表追加到root节点之后。
6.根据左子树链表是否为空确定返回的节点。
     */

    public TreeNode Convert(TreeNode pRootOfTree) {

        if (pRootOfTree==null)
            return null;
        if (pRootOfTree.left==null && pRootOfTree.right==null){
            return pRootOfTree;
        }

        // 1.将左子树构造成双链表，并返回链表头节点
        TreeNode left = Convert(pRootOfTree.left);
        //2.定位至左子树双链表最后一个节点。
        TreeNode pLeftLastNode = left;
        while (pLeftLastNode!=null&&pLeftLastNode.right!=null){
            //因为最后一个要么是叶子节点的右节点要么就是无右子树的左子树根节点
            pLeftLastNode = pLeftLastNode.right;
        }
        // 3.如果左子树链表不为空的话，将当前root追加到左子树链表
        if (left!=null){
            pLeftLastNode.right = pRootOfTree;
            pRootOfTree.left = pLeftLastNode;
        }

        // 4.将右子树构造成双链表，并返回链表头节点
        TreeNode right = Convert(pRootOfTree.right);
        // 5.如果右子树链表不为空的话，将该链表追加到root节点之后
        if (right!=null){
            pRootOfTree.right = right;
            right.left = pRootOfTree;
        }
        return left!=null?left:pRootOfTree;

    }
}