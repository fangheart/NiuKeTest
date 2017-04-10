package SixFive.NK57GetNextTreeNode;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*
题目描述
给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
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
                a
              /   \
             b     c
            / \   / \
           d   e  f  g
              / \
              h  i

      中序遍历为 d,b,h,e,i,a,f,c,g
      情况1：如结点b存在右孩子，他的下一个结点为右子树里面最左结点为h
      情况2：结点d下一个结点为b,结点h下一个结点为e,i的下一个结点为a。
      情况2总结起来就是向上遍历直到当前结点为父节点的左孩子结点
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode==null)
            return null;
        if (pNode.right!=null){//如果结点存在右子树就找右子树里面的最左结点
            pNode = pNode.right;
            while (pNode.left!=null){
                pNode = pNode.left;
            }
            return pNode;
        }
        while(pNode.next!=null){//如果不存在右子树结点就找第一个当前结点为父结点左孩子的父节点
            if (pNode.next.left==pNode)
                return pNode.next;
            pNode = pNode.next;
        }
        return null;//知道根节点也没有找到
    }

}