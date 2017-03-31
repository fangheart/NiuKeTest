package SixFive.FindFirstCommonNode36;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*
题目描述
输入两个链表，找出它们的第一个公共结点。
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
找出2个链表的长度，然后让长的先走两个链表的长度差，然后再一起走
（因为2个链表用公共的尾部）

     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1==null||pHead2==null)
            return null;

        int l1 = 1;
        int l2  = 1;
        ListNode ph1 = pHead1;
        ListNode ph2 = pHead2;
        while(ph1!=null){
            ph1 = ph1.next;
            l1++;
        }
        while(ph2!=null){
            ph2 = ph2.next;
            l2++;
        }
        if (l1>=l2){
            int step = l1-l2;
            while (step-->0){
                pHead1 = pHead1.next;
            }
        }else {
            int step = l2-l1;
            while (step-->0){
                pHead2 = pHead2.next;
            }

        }
        while (pHead1!=null){
            if (pHead1==pHead2)
                return pHead1;
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return pHead1;
    }
}