package SixFive.NK55EntryNodeOfLoop;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*
题目描述
一个链表中包含环，请找出该链表的环的入口结点。
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
    1.第一步，找环中相汇点。分别用p1，p2指向链表头部，p1每次走一步，p2每次走二步，
    直到p1==p2找到在环中的相汇点。

    2.第二步，找环的入口。
    接上步，当p1==p2时，p2所经过节点数为2x,p1所经过节点数为x,
    设环中有n个节点,p2比p1多走一圈有2x=n+x;n=x;
    可以看出p1实际走了一个环的步数，再让p2指向链表头部，p1位置不变，p1,p2每次走一步直到p1==p2;
    此时p1指向环的入口。
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode meetNode = meetingNode(pHead);
        if (meetNode==null)
            return null;

        //先找到走到相交结点时候走了多少部
        ListNode l1 = pHead;
        int step = 1;
        while (l1.next!=meetNode){
            step++;
            l1 = l1.next;
        }

        //快指针先走一个环的步数
        l1 = pHead;
        for (int i = 0; i < step; i++) {
            l1 = l1.next;
        }

        ListNode l2 = pHead;
        while(l1!=l2){
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1;

    }
    public ListNode meetingNode(ListNode pHead){
        if (pHead==null)
            return null;
        ListNode pSlow = pHead.next;
        if (pSlow==null)
            return null;
        ListNode pFast = pSlow.next;
        while (pSlow!=null && pFast!=null){
            if (pFast==pSlow)
                return pFast;

            pSlow = pSlow.next;

            pFast = pFast.next;

            if (pFast!=null)
                pFast = pFast.next;//快指针走两步慢指针走一步
        }
        return null;
    }

}