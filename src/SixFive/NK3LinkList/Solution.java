package SixFive.NK3LinkList;

import java.util.ArrayList;

/**
 * Created by FangHeart on 2017/3/19.
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
           this.val = val;
    }
}
/*
输入一个链表，从尾到头打印链表每个节点的值
 */
public class Solution {
    public static void main(String[] args){

    }
    ArrayList<Integer> arrayList = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        if (listNode!=null){
            this.printListFromTailToHead(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }
}