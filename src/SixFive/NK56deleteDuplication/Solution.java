package SixFive.NK56deleteDuplication;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*
题目描述
在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
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
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead==null)
            return null;
        if (pHead!=null&&pHead.next==null)
            return pHead;
        ListNode first = new ListNode(-1); //trick标志

        first.next = pHead;
        ListNode p = pHead;
        ListNode last = first;

        while (p!=null&&p.next!=null){
            if (p.val==p.next.val){
                int val = p.val;
                while (p!=null&&p.val==val)
                    p = p.next;
                last.next = p;
            }else {
                last = p;
                p = p.next;
            }
        }
        return first.next;
    }

}