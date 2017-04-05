package SixFive.NK14FindKthToTail;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*
输入一个链表，输出该链表中倒数第k个结点。
 */
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
最佳代码：Java代码，通过校验。代码思路如下：
两个指针，先让第一个指针和第二个指针都指向头结点，然后再让第一个指正走(k-1)步，到达第k个节点。
然后两个指针同时往后移动，当第一个结点到达末尾的时候，第二个结点所在位置就是倒数第k个节点了。。
     */
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head==null||k<=0)
            return null;
        ListNode preNode = head;
        ListNode lastNode = head;
        for (int i = 1; i < k; i++) {
            if (preNode.next!=null){
                preNode = preNode.next;
            }else {
                return null;
            }
        }
        while (preNode.next!=null){
            preNode = preNode.next;
            lastNode = lastNode.next;
        }
        return lastNode;
    }
}