package SixFive.NK16ListMerge;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*
题目描述
输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
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
    非递归版本，然而时间复杂度过大，那么考虑递归版本
     */
    public ListNode Merge2(ListNode list1,ListNode list2) {
        ListNode list = null;
        ListNode next = null;
        if (list1==null && list2==null)
            return null;
        else if(list1==null || list2==null){
            if (list1==null)
                return list2;
            else
                return list1;
        }else {
            while (list1!=null||list2!=null){
                if (list1.val<=list2.val) {
                    if (list==null){
                        list = list1;
                        list.next = next;
                    }else {
                        next = list1;
                        list = list.next;
                        next = next.next;
                    }
                }else {
                    if (list==null){
                        list = list2;
                        list.next = next;
                    }else {
                        next = list2;
                        list = list.next;
                        next = list2.next;
                    }

                }
            }
        }
        return list;
    }
    /*
    递归版本
     */
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode headNode  = null;
        if (list1==null)
            return list2;
        else if (list2==null)
            return list1;
        else {
            if(list1.val<list2.val){
                headNode = list1;
                headNode.next = Merge(list1.next,list2);
            }else {
                headNode = list2;
                headNode.next = Merge(list1,list2.next);
            }
        }
        return headNode;
    }
}