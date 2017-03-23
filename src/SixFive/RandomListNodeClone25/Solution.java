package SixFive.RandomListNodeClone25;

/**
 * Created by FangHeart on 2017/3/19.
 */
/*
题目描述
输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
返回结果为复制后复杂链表的head。
（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class Solution {
    public static void main(String[] args){

    }
    /*
    递归法
     */
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead==null)
            return null;
        RandomListNode randomListNodeHead = new RandomListNode(pHead.label);
        randomListNodeHead.next = pHead.next;
        randomListNodeHead.random = pHead.random;

        //递归其他节点
        randomListNodeHead.next = Clone(pHead.next);
        return  randomListNodeHead;
    }
    /*
    方法二：拆分法
     */
    public RandomListNode Clone2(RandomListNode pHead){
        if (pHead==null)
            return null;
        RandomListNode pCur = pHead;
        //在每一个节点后增加一个和他相同的节点如A>B>C变为A>A'>B>B'>C>C'
        while(pCur!=null){
            RandomListNode node = new RandomListNode(pCur.label);
            node.next = pCur.next;
            node.random = pCur.random;
            pCur.next = node;
            pCur = node.next;

        }
        pCur = pHead;//置换为头结点

        RandomListNode pCloneHead = pHead.next;
        RandomListNode cur = pCloneHead;
        //链表拆分
        while(pCur!=null){
            pCur.next = pCur.next.next;
            if (cur.next!=null){
                cur.next = cur.next.next;
            }
            pCur = pCur.next;
            cur = cur.next;
        }
        return pCloneHead;
    }
}