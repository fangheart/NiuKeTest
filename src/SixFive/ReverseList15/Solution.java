package SixFive.ReverseList15;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*
题目描述
输入一个链表，反转链表后，输出链表的所有元素。
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
方法一：递归法
     */
    public ListNode ReverseList2(ListNode head) {
        if (head==null || head.next==null)
            return head;
        ListNode h = ReverseList(head.next);

        head.next.next = head;
        head.next = null;
        return h;
    }
    /*
方法二：正常替换法
 */
    public ListNode ReverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        if (head==null || head.next==null)
            return head;
        while (head!=null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}